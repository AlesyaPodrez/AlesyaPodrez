package com.springapp.mvc.controller;

import com.dropbox.core.DbxException;
import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import com.springapp.mvc.service.Dropbox;
import com.springapp.mvc.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@MultipartConfig(maxFileSize = 1000000000)
public class AllController {

    private ActorRepository actorRepository;
    private PostRepository postRepository;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;
    private StaffRepository staffRepository;
    private TypeRepository typeRepository;
    private StaffProjectRepository staffProjectRepository;
    private ActorValidator actorValidator;
    private PostValidator postValidator;
    private ProjectValidator projectValidator;
    private RoleValidator roleValidator;
    private StaffValidator staffValidator;
    private TypeValidator typeValidator;

    @Autowired
    public AllController(ActorRepository actorRepository, PostRepository postRepository, ProjectRepository projectRepository, RoleRepository roleRepository,
                         StaffRepository staffRepository, TypeRepository typeRepository, StaffProjectRepository staffProjectRepository,
                         ActorValidator actorValidator, PostValidator postValidator, ProjectValidator projectValidator, RoleValidator roleValidator,
                         StaffValidator staffValidator, TypeValidator typeValidator){
        this.actorRepository = actorRepository;
        this.postRepository = postRepository;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
        this.staffRepository = staffRepository;
        this.typeRepository = typeRepository;
        this.staffProjectRepository = staffProjectRepository;
        this.actorValidator = actorValidator;
        this.postValidator = postValidator;
        this.projectValidator = projectValidator;
        this.roleValidator = roleValidator;
        this.staffValidator = staffValidator;
        this.typeValidator  = typeValidator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Actor> actor = this.actorRepository.listAll();
        model.addAttribute("actor", actor);

        List<Post> post = this.postRepository.listAll();
        model.addAttribute("post", post);

        List<Project> project = this.projectRepository.listAll();
        model.addAttribute("project", project);

        List<Role> role = this.roleRepository.listAll();
        model.addAttribute("role", role);

        List<Staff> staff = this.staffRepository.listAll();
        model.addAttribute("staff", staff);

        List<myType> myType = this.typeRepository.listAll();
        model.addAttribute("type", myType);

        return "index";
    }

    @RequestMapping(value = "addType", method = RequestMethod.GET)
    public String addType(Model model) throws SQLException {
        model.addAttribute("type", new myType());
        return "addType";
    }

    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public String addType(@ModelAttribute("type") myType type, BindingResult bindingResult) throws SQLException{
        this.typeValidator.validate(type, bindingResult);
        if(bindingResult.hasErrors()){
            return "addType";
        }
        this.typeRepository.addType(type);
        return "redirect:allType";
    }

    @RequestMapping(value = "addActor", method = RequestMethod.GET)
    public String addActor(Model model) throws SQLException{
        model.addAttribute("actor", new Actor());
        return "addActor";
    }

    @RequestMapping(value = "addActor", method = RequestMethod.POST)

    public String addActor(  @RequestParam("surname") String surname,
                            @RequestParam("name") String name,
                            @RequestParam("lastname") String lastname,
                            @RequestParam("dateOfBirth") String dateOfBirth,
                            @RequestParam("experience") String experience,
                            @RequestParam("image")MultipartFile img) throws IOException, DbxException {

        Actor actor = new Actor();
        actor.setExperience(experience);
        actor.setDateOfBirth(dateOfBirth);
        actor.setLastname(lastname);
        actor.setName(name);
        actor.setSurname(surname);
        Dropbox dropbox = new Dropbox();
        actor.setImage(dropbox.UploadingFile(img));
        this.actorRepository.addActor(actor);
        return "redirect:allActor";
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.GET)
     public ModelAndView addStaff(Model model) throws SQLException{
        model.addAttribute("staff", new Staff());
        ModelAndView modelAndView = new ModelAndView("addStaff");
        List<Post> post = this.postRepository.listAll();
        modelAndView.addObject("allPost", post);
        return modelAndView;
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public String addStaff(@RequestParam("idPost") Integer idPost,
                           @RequestParam("surname") String surname,
                           @RequestParam("name") String name,
                           @RequestParam("lastname") String lastname,
                           @RequestParam("dateOfBirth") String dateOfBirth,
                           @RequestParam("experience") String experience,
                           @RequestParam("image")MultipartFile img) throws IOException, DbxException {
        Staff staff = new Staff();
        staff.setSurname(surname);
        staff.setName(name);
        staff.setLastname(lastname);
        staff.setDateOfBirth(dateOfBirth);
        staff.setExperience(experience);
        staff.setIdPost(postRepository.findPost(idPost));
        Dropbox dropbox = new Dropbox();
        staff.setImage(dropbox.UploadingFile(img));
        this.staffRepository.addStaff(staff);
        return "redirect:allStaff";
    }

    @RequestMapping(value = "addProject", method = RequestMethod.GET)
    public ModelAndView addProject(Model model) throws SQLException{
        model.addAttribute("project", new Project());
        ModelAndView modelAndView = new ModelAndView("addProject");
        List<myType> type = this.typeRepository.listAll();
        modelAndView.addObject("allType", type);
        return modelAndView;
    }

    @RequestMapping(value = "addProject", method = RequestMethod.POST)
    public String addProject(@RequestParam("year") String year,
                                   @RequestParam("nameProject") String nameProject,
                                   @RequestParam("country") String country,
                                   @RequestParam("idType") Integer idType,
                                   @RequestParam("image") MultipartFile img) throws IOException, DbxException {

            Project project = new Project();
            project.setYear(year);
            project.setNameProject(nameProject);
            project.setCountry(country);
            project.setIdType(typeRepository.findType(idType));
            Dropbox dropbox = new Dropbox();
            project.setImage(dropbox.UploadingFile(img));
            this.projectRepository.addProject(project);

            return "redirect:/allProject";

    }

    @RequestMapping(value = "addPost", method = RequestMethod.GET)
    public String addPost(Model model) throws SQLException{
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @RequestMapping(value = "addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") Post post, BindingResult bindingResult) throws SQLException{
        this.postValidator.validate(post, bindingResult);
        if(bindingResult.hasErrors()){
            return "addPost";
        }
        this.postRepository.addPost(post);
        return "redirect:allPost";
    }

    @RequestMapping(value = "/addRole/{id}", method = RequestMethod.GET)
     public ModelAndView addRole(@PathVariable(value = "id") Integer id, Model model) throws SQLException{
        model.addAttribute("role", new Role());
        ModelAndView modelAndView = new ModelAndView("addRole");
        List<Actor> actor = this.actorRepository.listAll();
        model.addAttribute("allActor", actor);
        List<Project> project = this.projectRepository.findProjectID(id);
        model.addAttribute("allProject", project);
        return modelAndView;
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public String addRole(@RequestParam("nameRole") String nameRole,
                                @RequestParam("idActor") Integer idActor,
                                @RequestParam("idProject") Integer idProject) throws SQLException{
            Role role = new Role();
            role.setNameRole(nameRole);
            role.setIdActor(actorRepository.findActor(idActor));
            role.setIdProject(projectRepository.findProject(idProject));
            this.roleRepository.addRole(role);
            return "redirect:/showProject/"+idProject;
    }

    @RequestMapping(value = "/addStaffProject/{id}", method = RequestMethod.GET)
    public ModelAndView addStaffProject(@PathVariable(value = "id") Integer id, Model model)throws SQLException {
        model.addAttribute("staff_project", new StaffProject());
        ModelAndView modelAndView = new ModelAndView("addStaffProject");
        List<Staff> staff = this.staffRepository.listAll();
        model.addAttribute("allStaff", staff);
        List<Project> project = this.projectRepository.findProjectID(id);
        model.addAttribute("allProject", project);
        List<Post> post = this.postRepository.listAll();
        model.addAttribute("allPost", post);
        return modelAndView;
    }

    @RequestMapping(value = "/addStaffProject", method = RequestMethod.POST)
    public String addStaffProject(@RequestParam("idStaff") Integer idStaff,
                          @RequestParam("idProject") Integer idProject) throws SQLException{
        StaffProject staffProject = new StaffProject();
        staffProject.setIdStaff(staffRepository.findStaff(idStaff));
        staffProject.setIdProject(projectRepository.findProject(idProject));
        this.staffProjectRepository.addStaffProject(staffProject);
        String str = "redirect:showProject/"+idProject;
        return str;
    }

    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.GET)
    public String deleteType(@PathVariable Integer id) throws SQLException{
        this.typeRepository.removeType(id);
        return "redirect:/allType";
    }

    @RequestMapping(value = "deleteActor/{id}", method = RequestMethod.GET)
    public String deleteActor(@PathVariable Integer id) throws SQLException{
        this.actorRepository.removeActor(id);
        return "redirect:/allActor";
    }

    @RequestMapping(value = "deleteStaff/{id}", method = RequestMethod.GET)
    public String deleteStaff(@PathVariable Integer id) throws SQLException{
        this.staffRepository.removeStaff(id);
        return "redirect:/allStaff";
    }

    @RequestMapping(value = "deleteProject/{id}", method = RequestMethod.GET)
    public String deleteProject(@PathVariable Integer id) throws SQLException{
        this.projectRepository.removeProject(id);
        return "redirect:/allProject";
    }

    @RequestMapping(value = "deletePost/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable Integer id) throws SQLException{
        this.postRepository.removePost(id);
        return "redirect:/allPost";
    }

    @RequestMapping(value = "deleteStaffProject/{id}", method = RequestMethod.GET)
    public String deleteStaffProject(@PathVariable Integer id) throws SQLException{
        StaffProject staffProject = this.staffProjectRepository.findStaffProject(id);
        Project project = staffProject.getIdProject();
        this.staffProjectRepository.removeStaffProject(id);
        String str = "redirect:/showProject/"+project.getIdProject();
        return str;
    }

    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable Integer id) throws SQLException{
        Role role = this.roleRepository.findRoleID(id);
        Project project = role.getIdProject();
        this.roleRepository.removeRole(id);
        String str = "redirect:/showProject/"+project.getIdProject();
        return str;
    }

    @RequestMapping(value = "editType/{id}", method = RequestMethod.GET)
    public String editType(@PathVariable(value="id") Integer id, Model model) throws SQLException{
        model.addAttribute("type", this.typeRepository.findType(id));
        return "editType";
    }

    @RequestMapping(value = "/editType", method = RequestMethod.POST)
    public String editType(@ModelAttribute("type") myType type, BindingResult bindingResult) throws SQLException{
        this.typeValidator.validate(type, bindingResult);
        if(bindingResult.hasErrors()){
            return "editType";
        }
        this.typeRepository.updateType(type);
        return "redirect:allType";
    }

    @RequestMapping(value = "editActor/{id}", method = RequestMethod.GET)
    public String editActor(@PathVariable(value="id") Integer id, Model model) throws SQLException{
        model.addAttribute("actor", this.actorRepository.findActor(id));
        return "editActor";
    }

    @RequestMapping(value = "/editActor", method = RequestMethod.POST)
    public String editActor(@ModelAttribute("actor") Actor actor, BindingResult bindingResult) throws SQLException{
        this.actorValidator.validate(actor, bindingResult);
        if(bindingResult.hasErrors()){
            return "editActor";
        }
        this.actorRepository.updateActor(actor);
        return "redirect:/allActor";
    }

    @RequestMapping(value = "editStaff/{id}", method = RequestMethod.GET)
    public String editStaff(@PathVariable(value="id") Integer id, Model model) throws SQLException{
        model.addAttribute("staff", this.staffRepository.findStaff(id));
        Staff staff = this.staffRepository.findStaff(id);
        Post post = staff.getIdPost();
        List<Post> post1 = this.postRepository.findPostStaff(post.getIdPost());
        model.addAttribute("allPost", post1);
        List<Project> project = this.projectRepository.listAll();
        model.addAttribute("allProject", project);
        return "editStaff";
    }

    @RequestMapping(value = "/editStaff", method = RequestMethod.POST)
    public String editStaff(@RequestParam("idStaff") Integer idStaff,
            @RequestParam("idPost") Integer idPost,
                            @RequestParam("surname") String surname,
                            @RequestParam("name") String name,
                            @RequestParam("lastname") String lastname,
                            @RequestParam("dateOfBirth") String dateOfBirth,
                            @RequestParam("experience") String experience,
            @RequestParam("image")MultipartFile img) throws IOException, DbxException {
        Staff staff = staffRepository.findStaff(idStaff);
        staff.setSurname(surname);
        staff.setName(name);
        staff.setLastname(lastname);
        staff.setDateOfBirth(dateOfBirth);
        staff.setExperience(experience);
        staff.setIdPost(postRepository.findPost(idPost));
        Dropbox dropbox = new Dropbox();
        staff.setImage(dropbox.UploadingFile(img));
        this.staffRepository.updateStaff(staff);
        return "redirect:allStaff";
    }

    @RequestMapping(value = "editPost/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable(value="id") Integer id, Model model) throws SQLException{
        model.addAttribute("post", this.postRepository.findPost(id));
        return "editPost";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.POST)
    public String editPost(@ModelAttribute("post") Post post, BindingResult bindingResult) throws SQLException{
        this.postValidator.validate(post, bindingResult);
        if(bindingResult.hasErrors()){
            return "editPost";
        }
        this.postRepository.updatePost(post);
        return "redirect:allPost";
    }

    @RequestMapping(value = "editProject/{id}", method = RequestMethod.GET)
    public String editProject(@PathVariable(value="id") Integer id, Model model) throws SQLException{
        model.addAttribute("project", this.projectRepository.findProject(id));
        Project project =  this.projectRepository.findProject(id);
        myType mytype = project.getIdType();
        List<myType> type = this.typeRepository.findTypeProject(mytype.getIdType());
        model.addAttribute("allType", type);
        List<Role> role = this.roleRepository.listAll();
        model.addAttribute("allRole", role);
        return "editProject";
    }

    @RequestMapping(value = "/editProject", method = RequestMethod.POST)
    public String editProject(@RequestParam("idProject") Integer idProject,
        @RequestParam("year") String year,
        @RequestParam("nameProject") String nameProject,
        @RequestParam("country") String country,
        @RequestParam("idType") Integer idType) throws SQLException{
            Project project = projectRepository.findProject(idProject);
        project.setYear(year);
        project.setNameProject(nameProject);
        project.setCountry(country);
        project.setIdType(typeRepository.findType(idType));
            this.projectRepository.updateProject(project);
            return "redirect:allProject";
    }

    @RequestMapping(value = "/editRole/{id}", method = RequestMethod.GET)
    public ModelAndView editRole(@PathVariable(value = "id") Integer id, Model model) throws SQLException{
        model.addAttribute("role", this.roleRepository.findRoleID(id));
        Role role = this.roleRepository.findRoleID(id);
        Project project = role.getIdProject();
        Actor actor = role.getIdActor();
        ModelAndView modelAndView = new ModelAndView("editRole");
        List<Actor> actor1 = this.actorRepository.findActorRole(actor.getIdActor());
        model.addAttribute("allActor", actor1);
        List<Project> project1 = this.projectRepository.findProjectID(project.getIdProject());
        model.addAttribute("allProject", project1);
        return modelAndView;
    }

    @RequestMapping(value = "/editRole", method = RequestMethod.POST)
    public String editRole(@RequestParam("idRole") Integer idRole,
                           @RequestParam("nameRole") String nameRole,
                          @RequestParam("idActor") Integer idActor,
                          @RequestParam("idProject") Integer idProject) throws SQLException{
        Role role = roleRepository.findRoleID(idRole);
        role.setNameRole(nameRole);
        role.setIdActor(actorRepository.findActor(idActor));
        role.setIdProject(projectRepository.findProject(idProject));
        this.roleRepository.updateRole(role);
        String str = "redirect:showProject/"+idProject;
        return str;
    }

    @RequestMapping(value = "/editStaffProject/{id}", method = RequestMethod.GET)
    public ModelAndView editStaffProject(@PathVariable(value = "id") Integer id, Model model) throws SQLException{
        model.addAttribute("staff_project", this.staffProjectRepository.findStaffProject(id));
        StaffProject staffProject = this.staffProjectRepository.findStaffProject(id);
        Project project = staffProject.getIdProject();
        Post post = staffProject.getIdStaff().getIdPost();
        Staff staff1 = staffProject.getIdStaff();
        ModelAndView modelAndView = new ModelAndView("editStaffProject");
        List<Staff> staff = this.staffRepository.findStaffID(post.getIdPost(), staff1.getIdStaff());
        model.addAttribute("allStaff", staff);
        List<Project> project1 = this.projectRepository.findProjectID(project.getIdProject());
        model.addAttribute("allProject", project1);
        List<Post> post1 = this.postRepository.findPostStaff(post.getIdPost());
        model.addAttribute("allPost", post1);
        return modelAndView;
    }

    @RequestMapping(value = "/editStaffProject", method = RequestMethod.POST)
    public String editStaffProject(@RequestParam("idStaffProject") Integer idStaffProject,
                           @RequestParam("idStaff") Integer idStaff,
                           @RequestParam("idProject") Integer idProject) throws SQLException{
        StaffProject staffProject = staffProjectRepository.findStaffProject(idStaffProject);
        staffProject.setIdStaff(staffRepository.findStaff(idStaff));
        staffProject.setIdProject(projectRepository.findProject(idProject));
        this.staffProjectRepository.updateStaffProject(staffProject);
        String str = "redirect:showProject/"+idProject;
        return str;
    }

    @RequestMapping(value = "allProject", method = RequestMethod.GET)
    public String allProject(Model model) throws SQLException{
        List<Project> project = this.projectRepository.listAll();
        model.addAttribute("project", project);
        List<Project> projectSearch = this.projectRepository.findProjectSearch();
        model.addAttribute("projectSearch", projectSearch);
        return "allProject";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView allProjectSearch( HttpServletRequest request) throws SQLException{
        ModelAndView modelAndView = new ModelAndView("allProject");
        request.getParameter("year");
        if(request.getParameter("year").equals("0")){
            modelAndView.addObject("error", "Пустой ввод");
            modelAndView.addObject("project", this.projectRepository.listAll());
            List<Project> projectSearch = this.projectRepository.findProjectSearch();
            modelAndView.addObject("projectSearch", projectSearch);
            }else {
            List<Project> projects = searchByYear(this.projectRepository.listAll(), request.getParameter("year"));
            modelAndView.addObject("project", projects);
        }
        return modelAndView;
    }

    @RequestMapping(value = "allActor", method = RequestMethod.GET)
    public String allActor(Model model) throws SQLException{
        List<Actor> actor = this.actorRepository.listAll();
        model.addAttribute("actor", actor);
        return "allActor";
    }

    @RequestMapping(value = "allStaff", method = RequestMethod.GET)
    public String allStaff(Model model) throws SQLException{
        List<Staff> staff = this.staffRepository.listAll();
        model.addAttribute("staff", staff);
        return "allStaff";
    }

    @RequestMapping(value = "allPost", method = RequestMethod.GET)
    public String allPost(Model model) throws SQLException{
        List<Post> post = this.postRepository.listAll();
        model.addAttribute("post", post);
        return "allPost";
    }

    @RequestMapping(value = "allType", method = RequestMethod.GET)
    public String allType(Model model)throws SQLException {
        List<myType> type = this.typeRepository.listAll();
        model.addAttribute("type", type);
        return "allType";
    }

    @RequestMapping(value = "showActor/{id}", method = RequestMethod.GET)
    public ModelAndView showActor(@PathVariable(value = "id") Integer id, Model model) throws SQLException{
        model.addAttribute("actor", this.actorRepository.findActor(id));
        List<Role> role = this.roleRepository.findRoleActor(id);
        model.addAttribute("allRole", role);
        ModelAndView modelAndView = new ModelAndView("showActor");
        return modelAndView;
    }

    @RequestMapping(value = "/showActor", method = RequestMethod.POST)
    public String showActor(@ModelAttribute("actor") Actor actor) throws SQLException{
        this.actorRepository.updateActor(actor);
        return "redirect:showActor";
    }

    @RequestMapping(value = "showStaff/{id}", method = RequestMethod.GET)
    public ModelAndView showStaff(@PathVariable(value = "id") Integer id, Model model) throws SQLException{
        model.addAttribute("staff", this.staffRepository.findStaff(id));
        List<StaffProject> staffProject = this.staffProjectRepository.findStaffProjectID(id);
        model.addAttribute("allProject", staffProject);
        ModelAndView modelAndView = new ModelAndView("showStaff");
        return modelAndView;
    }

    @RequestMapping(value = "/showStaff", method = RequestMethod.POST)
    public String showActor(@ModelAttribute("staff") Staff staff) throws SQLException{
        this.staffRepository.updateStaff(staff);
        return "redirect:showStaff";
    }

    @RequestMapping(value = "showProject/{id}", method = RequestMethod.GET)
    public ModelAndView showProject(@PathVariable(value = "id") Integer id, Model model) throws SQLException{
        model.addAttribute("project", this.projectRepository.findProject(id));
        ModelAndView modelAndView = new ModelAndView("showProject");
        List<Role> role = this.roleRepository.findRole(id);
        model.addAttribute("idRole", role);
        List<StaffProject> staffProject = this.staffProjectRepository.findStaffProjectID(id);
        model.addAttribute("idStaffProject", staffProject);
        return modelAndView;
    }

    @RequestMapping(value = "/showProject", method = RequestMethod.POST)
    public String showProject(@ModelAttribute("project") Project project) throws SQLException{
        this.projectRepository.updateProject(project);
        return "redirect:showProject";
    }

    @RequestMapping(value = "/siteMap", method = RequestMethod.GET)
    public String siteMap(Model model) {
        return "siteMap";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts(Model model) {
        return "contacts";
    }

    public List<Project> searchByYear(List<Project> projects, String year){
        List<Project> result = new ArrayList<Project>();
        for (Project project: projects){
            if (project.getYear().equals(year))
                result.add(project);
        }
        return result;
    }

}
