package classwork.util.externalize;

import org.codehaus.jackson.map.ObjectMapper;
import classwork.entity.externalize.Fallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** Восстановление данных из сохраненного состояния в файле temp.extern.out
 *  Сохраниение в json формате в файл result_parameters.extern.json
 * */

public class WriteJson {

	public static final String SOURCE_FILE = "temp.extern.out";
	public static final String RESULT_FILE = "result_parameters.extern.json";

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		System.out.println("Читаем из файла " + SOURCE_FILE);
		FileInputStream fileInputStream = new FileInputStream(SOURCE_FILE);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Fallback business = (Fallback)objectInputStream.readObject();
		System.out.println("Данные считаны\n" + business.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Записываем данные в файла " + RESULT_FILE);
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_FILE), business);
		System.out.println("Данные записаны на диск в файл " + RESULT_FILE);
		
	}
	
}
