# EasyUnzip Tool

## English

### Description
The EasyUnzip tool is a simple Java class designed to facilitate the extraction of files from a zip archive on Android devices. It can be used by Android developers who want a straightforward way to unzip files within their mobile applications.

### Usage

1. **Include EasyUnzip in your project:**
   - Copy the `EasyUnzip.java` file into your Android project's source code.

2. **Initialize EasyUnzip:**
   ```java
   // Example usage in an Android activity
   File zipFile = Environment.getExternalStoragePublicDirectory("Download/yourZipFile.zip");
   File extractionPath = Environment.getExternalStoragePublicDirectory("Download/zipFileExtracted");
   EasyUnzip easyUnzip = new EasyUnzip(zipFile, extractionPath);
   ```

3. **Execute Unzipping:**
   ```java
   // Call the execute method to start the extraction process
   if (easyUnzip.execute()) {
       // Extraction successful
   } else {
       // Extraction failed
   }
   ```

4. **Additional Notes:**
   - If needed, customize the tool according to your specific requirements.
   - Ensure appropriate permissions to read and write files on the device.

## Português

### Descrição
A ferramenta EasyUnzip é uma classe Java simples projetada para facilitar a extração de arquivos de um arquivo zip em dispositivos Android. Pode ser utilizada por desenvolvedores Android que desejam uma maneira direta de descompactar arquivos em suas aplicações móveis.

### Uso

1. **Inclua o EasyUnzip no seu projeto:**
   - Copie o arquivo `EasyUnzip.java` para o código-fonte do seu projeto Android.

2. **Inicialize o EasyUnzip:**
   ```java
   // Exemplo de uso em uma atividade Android
   File zipFile = Environment.getExternalStoragePublicDirectory("Download/seuArquivoZip.zip");
   File localExtracao = Environment.getExternalStoragePublicDirectory("Download/arquivoZipExtraido");
   EasyUnzip easyUnzip = new EasyUnzip(zipFile, localExtracao);
   ```

3. **Execute a Descompactação:**
   ```java
   // Chame o método execute para iniciar o processo de extração
   if (easyUnzip.execute()) {
       // Extração bem-sucedida
   } else {
       // Falha na extração
   }
   ```

4. **Notas Adicionais:**
   - Se necessário, customize a ferramenta de acordo com seus requisitos específicos.
   - Certifique-se de ter as permissões apropriadas para ler e escrever arquivos no dispositivo.