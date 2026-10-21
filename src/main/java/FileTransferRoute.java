import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class FileTransferRoute extends RouteBuilder {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new FileTransferRoute());
        main.run();
    }

    @Override
    public void configure() throws Exception {
        // Única Ruta: Lee de input, filtra solo CSV, transforma a mayúsculas y guarda en output.
        // Si entra un archivo .txt, el filtro lo ignorará y no pasará de este punto.
        from("file:input?noop=true")
            .filter(header("CamelFileName").endsWith(".csv"))
            .log("Procesando archivo válido CSV: ${file:name} a las ${date:now:yyyy-MM-dd HH:mm:ss}")
            .convertBodyTo(String.class)
            .transform().simple("${body.toUpperCase()}")
            .to("file:output");
    }
}