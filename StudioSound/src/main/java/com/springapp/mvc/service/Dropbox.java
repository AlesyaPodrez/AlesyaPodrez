package com.springapp.mvc.service;

import com.dropbox.core.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Dropbox {

	private static final String APP_KEY = "w4b5qk40dubj8hc";
	private static final String APP_SECRET = "85bsy21laqt8sx2";
	private static final String ACCESS_TOKEN = "nrcYtPlgUkwAAAAAAAARMFiVUF7sFoIERdqBoEGHBc6Lk2ElXZFZlTr2o0o7kFRp";

	private DbxClient client;

	public Dropbox() {

		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",
				Locale.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
		client = new DbxClient(config, ACCESS_TOKEN);
	}
	
	

	public String UploadingFile(MultipartFile file) throws DbxException,
			IOException {
		FileInputStream inputStream = (FileInputStream) file.getInputStream();
		try {
			DbxEntry.File uploadedFile = client.uploadFile("/".concat(file.getOriginalFilename()),
					DbxWriteMode.add(), file.getSize(), inputStream);
			String url = client.createShareableUrl(uploadedFile.path);
			return url.substring(0, url.length()-5).concat("?raw=1");
		} finally {
			inputStream.close();
		}
	}

}
