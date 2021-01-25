package classwork.util.externalize;

import classwork.da.externalize.ExternalizeReader;
import classwork.entity.externalize.Fallback;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * Чтение из файла objects_data.json и запись сериализации в файл temp.extern.out
 * */
public class ReadJson {

	public static final String SOURCE_FILE = "objects_data.json";
	public static final String RESULT_FILE = "temp.extern.out";

	public static void main(String[] args) throws IOException {

		System.out.println("Считываем данные из файла " + SOURCE_FILE);
		ExternalizeReader service = new ExternalizeReader();
		Fallback parameterInfo = service.read(SOURCE_FILE);
		System.out.println("Данные считаны\n" + parameterInfo.toString());
		
		System.out.println("Начинаем процесс сериализации");
		FileOutputStream fileOutputStream = new FileOutputStream(RESULT_FILE);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(parameterInfo);
		
		objectOutputStream.close();
		System.out.println("Сериализации завершена");
	}
	
}
