package bo.gob.aduana.vipas.utilitario.itextpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;

//protected  class Event implements PdfPageEventHelper{
    public class MyEvent extends PdfPageEventHelper {
private String encabezado;
    PdfTemplate total;
    Image img;
    String fecha;
    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	String path;
    String page_total;
    String usuario;
    public static int totalPages=0;
    
  
    /**
     * Crea el objecto PdfTemplate el cual contiene el numero total de
     * paginas en el documento
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }
    
    /**
     * Esta es el metodo a llamar cuando ocurra el evento onEndPage, es en este evento
     * donde crearemos el encabeazado de la pagina con los elementos indicados.
     */
     
    public void onEndPage(PdfWriter writer, Document document) {
        //PdfPTable table = new PdfPTable(3);
      
        try {
            float width = document.getPageSize().getWidth();
                    float height = document.getPageSize().getHeight();
                    writer.getDirectContentUnder().addImage(img, width, 0, 0, height, 0, 0);
        
            BaseFont bf = null;
            bf = BaseFont.createFont(path + "/fonts/times.ttf", BaseFont.CP1252, BaseFont.EMBEDDED);
            Phrase titreFormules =
                new Phrase("Certificado Generado en fecha: " + fecha , new Font(bf, 8, Font.ITALIC));
            Phrase user =
                    new Phrase("Usuario: " + usuario, new Font(bf, 8, Font.ITALIC));

           /* PdfContentByte cb = writer.getDirectContent();
                    cb.saveState();
                    String text = String.format(" %s de ", writer.getPageNumber());
             
                    float textBase = document.bottom() - 40;//y
                
                     
                    cb.beginText();
                    cb.setFontAndSize(bf, 8f);               
       
            cb.setTextMatrix(document.right() - 0, textBase);
            cb.showText(text);
            cb.endText();
            cb.addTemplate(total, document.right() -0, textBase);                  
            cb.restoreState();*/
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, titreFormules, 580, 45, 0);  
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, user, 580, 35, 0); 
        }
        catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
        catch(IOException de) {
            throw new ExceptionConverter(de);
        }
    }

    
    /**
     * Realiza el conteo de paginas al momento de cerrar el documento
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        BaseFont bf = null;

        try {
            bf = BaseFont.createFont(path + "/fonts/times.ttf", BaseFont.CP1252, BaseFont.EMBEDDED);
          
            total.beginText();
                    total.setFontAndSize(bf, 8f);
                    total.setTextMatrix(20, 0);
                    total.showText(String.valueOf(writer.getPageNumber() - 1));
                    total.endText();
        } catch (DocumentException e) {
        } catch (IOException e) {
        }
      
    }    
    
    // Getter and Setters
    
    public String getEncabezado() {
        return encabezado;
    }
    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public void setTotal(PdfTemplate total) {
        this.total = total;
    }

    public PdfTemplate getTotal() {
        return total;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
 
}
