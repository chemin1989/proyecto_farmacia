package gestorArchivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class GestorDeArchivos {
	private static final String ARCHIVOS_IMAGEN = "CarpetaImagenes";

	public static String rutaArchivo(int id) {

		String ruta = ARCHIVOS_IMAGEN + File.separator + id + ".jpg";

		File f = new File(ruta);

		return f.getAbsolutePath();

	}

	public static void guardarArchivo(Part imagen, String ruta) {

		File carpetaSubidas = new File(ARCHIVOS_IMAGEN);
		if (!carpetaSubidas.exists()) {
			carpetaSubidas.mkdirs();
		}

		try {
			InputStream is = imagen.getInputStream();
			FileOutputStream fos = new FileOutputStream(ARCHIVOS_IMAGEN + File.separator + ruta);
			byte[] leidos = new byte[1024];
			while (is.read(leidos) != -1) {
				fos.write(leidos);
			}
			is.close();
			fos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}