package com.isep.cardis.projet_fiches_module_A2.pdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.isep.cardis.projet_fiches_module_A2.sheet.*;

@Component
public class PdfGeneratorUtil {

	@Autowired
	private TemplateEngine templateEngine;
	


	public void createPdf(String templateName, Map map, Sheet Sheet) throws Exception {
		Assert.notNull(templateName, "The templateName can not be null");
		Context ctx = new Context();
		if (map != null) {
			Iterator itMap = map.entrySet().iterator();
			while (itMap.hasNext()) {
				Map.Entry pair = (Map.Entry) itMap.next();
				ctx.setVariable(pair.getKey().toString(), pair.getValue());
			}
		}

		String processedHtml = templateEngine.process(templateName, ctx);
		FileOutputStream os = null;
		File a = null;
		String fileName = Sheet.getTitle();
		try {

			os = new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/" + fileName + ".pdf"));

			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(processedHtml);
			renderer.layout();
			renderer.createPDF(os, false);
			renderer.finishPDF();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					/* ignore */ }
			}
		}
	}

	public void DownloadPDF(HttpServletResponse response, Sheet Sheet) throws IOException {
		
		String fileName = Sheet.getTitle();
		String FILE_PATH = System.getProperty("user.home") + "/Desktop/" + fileName + ".pdf";
		File file = new File(FILE_PATH);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = inStrem.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		outStream.flush();
		inStrem.close();
		file.delete();
	}
}
