package com.isep.cardis.projet_fiches_module_A2.pdf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.swing.JFileChooser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.springframework.core.io.FileSystemResource;

import com.lowagie.text.DocumentException;
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
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) { /*ignore*/ }
            }
        }
}
}
