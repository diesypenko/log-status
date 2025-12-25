package com.fileparser.util;

import java.io.File;
import java.util.List;

public class FileUtils {

	public static List<File> getJsonFiles(String path) {
	    File file = new File(path);

	    // 1) Якщо це файл *.json → повертаємо список із одного файла
	    if (file.isFile() && file.getName().endsWith(".json")) {
	        return List.of(file);
	    }

	    // 2) Якщо це директорія → повертаємо всі .json файли
	    if (file.isDirectory()) {
	        File[] files = file.listFiles((dir, name) -> name.endsWith(".json"));
	        return files != null ? List.of(files) : List.of();
	    }

	    // 3) Якщо ні файл, ні директорія → пустий список
	    return List.of();
	}
}