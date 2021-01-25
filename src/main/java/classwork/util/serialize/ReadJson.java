package classwork.util.serialize;

import classwork.da.serialize.JsonReader;
import classwork.entity.serialize.Fallback;
import classwork.da.serialize.SerializeWriter;
import java.io.IOException;


/**
 * Чтение из файла objects_data.json и запись сериализации в файл temp.serial.out
 * */
public class ReadJson {

    public static final String SOURCE_FILE = "objects_data.json";
    public static final String RESULT_FILE = "temp.serial.out";

    public static void main(String[] args) throws IOException {

        System.out.println("Считываем данные из файла " + SOURCE_FILE + "\n");
        Fallback srcData = new JsonReader().read(SOURCE_FILE);
        System.out.println(srcData);
        System.out.println();

        System.out.println("Записываем данные в файл " + RESULT_FILE + "\n");
        new SerializeWriter().customSerializeWriter(srcData, RESULT_FILE);
    }

}
