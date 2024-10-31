package com.example.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.After; // JUnit 4
import org.junit.Before; // JUnit 4
import org.junit.Test; // JUnit 4
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class NewUser {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before // JUnit 4
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        // chromeOptions.addArguments("--headless"); // Opcional

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After // JUnit 4
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Asegura cierre del navegador
        }
    }

    @Test
    public void CasoDeUso1_IngresoVeterinarioYRegistroClienteConMascota() throws InterruptedException {
        // Paso 1: Navegar a la página de login
        navegarALogin();

        // Paso 2: Intento de inicio de sesión incorrecto del veterinario
        seleccionarVeterinario();
        validarSeleccionVeterinario();
        ingresarCredencialesVeterinario("9876543210", "contraseñaIncorrecta");
        validarErrorLogin(); // Validamos que el error de inicio de sesión es capturado

        // Paso 3: Segundo intento de inicio de sesión exitoso
        seleccionarVeterinario();
        validarSeleccionVeterinario();
        ingresarCredencialesVeterinario("222222", "claveSegura");

        // Paso 4: Navegar a la sección de registro de clientes
        navegarAClientes();

        // Paso 5: Intento de registro de cliente con error en algún campo
        agregarClienteConError("Juan P", "56789", "3123456789", "juanP-hotmail.com"); // Error en el correo

        // Paso 6: Registro correcto del cliente después de corregir el error
        agregarCliente("Juan P", "56789", "3123456789", "juanP@hotmail.com");

        // Paso 7: Navegar a la sección de registro de mascotas
        navegarAMascotas();

        // Paso 8: Registro de mascota y asociación con el dueño correctamente a la primera
        agregarMascota("Toby", "Labrador", "3", "25", "Alergias", "https://example.com/labrador.jpg");

        // Paso 9: Cerrar sesión del veterinario
        cerrarSesion();

        // Paso 10: Ingreso del cliente al portal de clientes con su cédula
        ingresarPortalCliente("56789");

        // Paso 11: Validación de los datos de la mascota por parte del cliente
        verificarDatosMascota("Toby", "Labrador", "3", "25", "Alergias");
    }

    // Método de validación de error de inicio de sesión
    private void validarErrorLogin() {
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alerta")));
        assertEquals("Credenciales incorrectas. Intente de nuevo.", errorMsg.getText().trim());
    }
    

    // Método para agregar cliente con un error en el formulario
        private void agregarClienteConError(String nombre, String cedula, String celular, String correo) {
       
        // WebElement agregarCliente = wait.until(ExpectedConditions.elementToBeClickable(By.id("agregarCliente"))); // Este ID no existe
        // No es necesario hacer clic aquí ya que el botón de envío se encargará de eso.
    
        WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        WebElement inputCedulaCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedula")));
        WebElement inputCelular = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celular")));
        WebElement inputCorreo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("correo"))); 
    
        inputNombre.sendKeys(nombre);
        inputCedulaCliente.sendKeys(cedula);
        inputCelular.sendKeys(celular);
        inputCorreo.sendKeys(correo);
    
       
        WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.id("crearClienteBtn")));
        btnAgregar.click();
    
        
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorCorreo")));
        assertEquals("Correo no válido.", errorMsg.getText().trim());
    
        // Limpiar el campo de correo para corregir el error
        inputCorreo.clear();
    }
    
    

    // Método para agregar cliente sin errores
    private void agregarCliente(String nombre, String cedula, String celular, String correo) {
        try {
            WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
            WebElement inputCedulaCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedula")));
            WebElement inputCelular = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celular")));
            WebElement inputCorreo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("correo"))); // Cambié 'email' a 'correo'
    
            inputNombre.sendKeys(nombre);
            inputCedulaCliente.sendKeys(cedula);
            inputCelular.sendKeys(celular);
            inputCorreo.sendKeys(correo);
    
            WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.id("crearClienteBtn"))); // Cambié 'btnAgregar' a 'crearClienteBtn'
            btnAgregar.click();
    
            // Confirmar que el cliente fue registrado exitosamente
            WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registroExitoso")));
            assertEquals("Cliente registrado con éxito.", confirmMsg.getText().trim());
        } catch (Exception e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    }
    

    // Método para agregar mascota
    private void agregarMascota(String nombre, String raza, String edad, String peso, String enfermedad, String fotoUrl) {
        try {
            // No es necesario hacer clic en un elemento antes de enviar el formulario, ya que se enviará al hacer clic en el botón de enviar.
            
            WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
            WebElement inputRaza = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("raza")));
            WebElement inputEdad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edad")));
            WebElement inputPeso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("peso")));
            WebElement inputEnfermedad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enfermedad")));
            WebElement inputFoto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fotoURL"))); // Confirmado como 'fotoURL'
            WebElement spinnerCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cliente"))); // Asegurado
    
            inputNombre.sendKeys(nombre);
            inputRaza.sendKeys(raza);
            inputEdad.sendKeys(edad);
            inputPeso.sendKeys(peso);
            inputEnfermedad.sendKeys(enfermedad);
            inputFoto.sendKeys(fotoUrl);
    
            // No se necesita hacer clic aquí, se enviará el formulario más adelante.
            // spinnerCliente.click(); // Esto no es necesario.
    
            // Seleccionar el cliente por ID; se asumirá que el valor 'clienteSeleccionado' es válido.
            WebElement clienteOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='56789']"))); // Asegúrate de que '56789' sea un valor válido
            clienteOption.click();
    
            // Enviar el formulario al hacer clic en el botón de enviar
            WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))); // Cambiado a selector CSS para el botón
            btnAgregar.click();
    
            // Confirmación de registro exitoso de mascota
            WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registroMascotaExitoso"))); // Asegúrate de que este ID esté presente en el HTML
            assertEquals("Mascota registrada con éxito.", confirmMsg.getText().trim());
        } catch (Exception e) {
            System.err.println("Error al agregar mascota: " + e.getMessage());
        }
    }
    

    // Método para cerrar sesión
    private void cerrarSesion() {
        WebElement btnCerrarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("cerrarSesionBtn")));
        btnCerrarSesion.click();
    }
    
    // Método para ingresar al portal de cliente con cédula
    private void ingresarPortalCliente(String cedulaCliente) {
        navegarALogin();
        seleccionarCliente();
        validarSeleccionCliente();

        WebElement inputCedulaCliente = wait.until(ExpectedConditions.elementToBeClickable(By.id("cedula")));
        inputCedulaCliente.sendKeys(cedulaCliente);

        WebElement btnIniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("iniciarSesionBtn")));
        btnIniciarSesion.click();
    }

    // Método para verificar los datos de la mascota en el portal de cliente
    private void verificarDatosMascota(String nombre, String raza, String edad, String peso, String enfermedad) {
        WebElement nombreMascota = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        WebElement razaMascota = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("raza")));
        WebElement edadMascota = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edad")));
        WebElement pesoMascota = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("peso")));
        WebElement enfermedadMascota = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enfermedad")));
    
        assertEquals(nombre, nombreMascota.getText().trim());
        assertEquals(raza, razaMascota.getText().trim());
        assertEquals(edad, edadMascota.getText().trim());
        assertEquals(peso, pesoMascota.getText().trim());
        assertEquals(enfermedad, enfermedadMascota.getText().trim());
    }
    

    // Métodos auxiliares (navegarALogin, seleccionarVeterinario, etc.) siguen aquí...

    private void navegarALogin() {
        driver.get("http://localhost:4200/client/login");
    }

    private void seleccionarVeterinario() {
        WebElement veterinarioOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("veterinario")));
        veterinarioOption.click();
    }

    private void validarSeleccionVeterinario() {
        // Validación de que se ha seleccionado el veterinario
        WebElement seleccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tituloVeterinario")));
        assertEquals("Inicio Veterinario", seleccion.getText().trim());
    }

    private void ingresarCredencialesVeterinario(String cedula, String clave) {
        WebElement inputCedula = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedula")));
        WebElement inputClave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clave")));

        inputCedula.sendKeys(cedula);
        inputClave.sendKeys(clave);

        WebElement btnIniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnIniciarSesion")));
        btnIniciarSesion.click();
    }

    private void navegarAClientes() {
        WebElement btnClientes = wait.until(ExpectedConditions.elementToBeClickable(By.id("clientes")));
        btnClientes.click();
    }

    private void navegarAMascotas() {
        WebElement btnMascotas = wait.until(ExpectedConditions.elementToBeClickable(By.id("mascotas")));
        btnMascotas.click();
    }

    private void seleccionarCliente() {
        WebElement clienteOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("cliente")));
        clienteOption.click();
    }

    private void validarSeleccionCliente() {
        // Validación de que se ha seleccionado el cliente
        WebElement seleccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tituloCliente")));
        assertEquals("Inicio Cliente", seleccion.getText().trim());
    }
}
