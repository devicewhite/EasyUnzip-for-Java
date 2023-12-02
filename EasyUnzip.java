/*
 * Copyright(C) 2023 DeviceBlack
 *
 * Licensed under the Apache License, Version 2.0(the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.devicewhite.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Decompressor class to unzip a compressed file
 */
public class EasyUnzip {

	private File target;
	private File location;

	/**
	 * Constructor for EasyUnzip
	 *
	 * @param zipFile The target zip file to be decompressed
	 * @param path	The location to extract the contents of the zip file
	 */
	public EasyUnzip(File zipFile, File path) {
		target = zipFile;
		location = path;
		
		if(!path.exists()) path.mkdirs();
	}

	/**
	 * Checks and creates directories if they don't exist
	 *
	 * @param path The directory path to be checked and created
	 */
	private void dirChecker(String path) {
		File f = new File(location, path);
		if(!f.isDirectory()) f.mkdirs();
	}
	

	/**
	 * Executes the unzip operation
	 *
	 * @return True if the operation is successful, false otherwise
	 */
	public boolean execute() {
		FileInputStream fis = null;
		ZipInputStream zis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(target);
			zis = new ZipInputStream(fis);

			ZipEntry ze = null;
			while ((ze = zis.getNextEntry()) != null) {
				if (!ze.isDirectory()) {
					fos = new FileOutputStream(location + "/" + ze.getName());

					int b;
					while ((b = zis.read()) != -1) {
						fos.write(b);
					}

					zis.closeEntry();
					fos.close();
				} else {
					dirChecker(ze.getName());
				}
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (zis != null) zis.close();
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

