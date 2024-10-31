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
import org.openqa.selenium.support.ui.Select;
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
          //  driver.quit(); // Asegura cierre del navegador
        }
    }

    @Test
    public void CasoDeUso1_IngresoVeterinarioYRegistroClienteConMascota() throws InterruptedException {
        // Paso 1: Navegar a la página de login
        navegarALogin();

        // Paso 2: Intento de inicio de sesión incorrecto del veterinario
        seleccionarVeterinario();
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
    
    

    private void navegarALogin() {
        driver.get("http://localhost:4200/vet/login");
    }

    private void seleccionarVeterinario() {
        WebElement inputCedula = driver.findElement(By.id("cedula"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        
        // Primer intento de inicio de sesión
        inputCedula.sendKeys("VET123456");
        inputPassword.sendKeys("pass12");
        WebElement btnIniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
        btnIniciarSesion.click(); 
    
        // Segundo intento de inicio de sesión
        inputCedula.clear();
        inputPassword.clear();
        inputCedula.sendKeys("VET123456");
        inputPassword.sendKeys("pass123");
        btnIniciarSesion.click();
    
        // Navegar a la página de clientes y agregar cliente
        WebElement clientsPage = wait.until(ExpectedConditions.elementToBeClickable(By.id("clientsPage")));
        clientsPage.click();
    
        WebElement btnAddClient = wait.until(ExpectedConditions.elementToBeClickable(By.id("addClient")));
        btnAddClient.click();
    
        WebElement inputName = driver.findElement(By.id("nombre"));
        WebElement inputCedulaClient = driver.findElement(By.id("cedula"));
        WebElement inputPhone = driver.findElement(By.id("celular"));
        WebElement inputEmail = driver.findElement(By.id("correo"));
    
        // Primer intento de creación de cliente
        inputName.sendKeys("miguelito");
        inputCedulaClient.sendKeys("123456");
        inputPhone.sendKeys("3184406521");
        inputEmail.sendKeys("miguelelprogmail.com");
        WebElement btnCreateClient = wait.until(ExpectedConditions.elementToBeClickable(By.id("addClient")));
        btnCreateClient.click();
    
        // Segundo intento de creación de cliente con correo corregido
        inputName.clear();
        inputCedulaClient.clear();
        inputPhone.clear();
        inputEmail.clear();
        inputName.sendKeys("miguelito");
        inputCedulaClient.sendKeys("123456");
        inputPhone.sendKeys("3184406521");
        inputEmail.sendKeys("miguelelpro@gmail.com");
        btnCreateClient.click();
    
        // Navegar a la página de mascotas y agregar mascota
        WebElement petsPage = wait.until(ExpectedConditions.elementToBeClickable(By.id("petsPage")));
        petsPage.click();
    
        WebElement btnAddPet = wait.until(ExpectedConditions.elementToBeClickable(By.id("addPet")));
        btnAddPet.click();
    
        // Localizar los campos de entrada del formulario y llenar los datos necesarios
        WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        WebElement inputRaza = driver.findElement(By.id("raza"));
        WebElement inputEdad = driver.findElement(By.id("edad"));
        WebElement inputPeso = driver.findElement(By.id("peso"));
        WebElement inputFoto = driver.findElement(By.id("fotoURL"));
        WebElement inputEnfermedad = driver.findElement(By.id("enfermedad"));
        WebElement selectEstado = driver.findElement(By.id("estado"));
        Select dropdownEstado = new Select(selectEstado);
        WebElement selectCliente = driver.findElement(By.id("cliente"));
        Select dropdownCliente = new Select(selectCliente);

        // Llenar los campos con datos de prueba
        inputNombre.sendKeys("Bobby");
        inputRaza.sendKeys("Golden Retriever");
        inputEdad.sendKeys("3");
        inputPeso.sendKeys("15");
        inputFoto.sendKeys("https://example.com/photo-bobby.jpg");
        inputEnfermedad.sendKeys("Alergias");

        // Seleccionar valores de los dropdowns
        dropdownEstado.selectByValue("Activo");
        dropdownCliente.selectByValue("123456"); // Reemplaza "123456" con el valor adecuado para el cliente

        // Hacer clic en el botón para agregar la mascota
        WebElement btnAgregarMascota = driver.findElement(By.id("btnAgregar"));
        btnAgregarMascota.click();
    }
    

}
