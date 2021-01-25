package classwork.da.serialize;

import classwork.entity.serialize.Fallback;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeWriter {
	
	public void customSerializeWriter(Fallback parameters, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName)){
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(parameters);
			}
		}
	}
	
}
