package com.example.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.After; // JUnit 4
import org.junit.Before; // JUnit 4
import org.junit.Test; // JUnit 4
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

    @Test
    public void CasoDeUso2_NuevoTratamiento(){
        segundoCasoDeUso();
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
        dropdownCliente.selectByValue("123456");

        // Hacer clic en el botón para agregar la mascota
        WebElement element = driver.findElement(By.id("btnAgregar"));
        long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

        while (true) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            
            // Espera un momento para permitir la carga de nuevo contenido
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  // Ajusta el tiempo según sea necesario
        
            long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
        element.click();


       for (int i = 0; i < 3; i++) {
    try {
        WebElement cerrarSesion = driver.findElement(By.id("cerrarSesion"));
        cerrarSesion.click();
        break; // Salir del bucle si se realiza el clic exitosamente
    } catch (StaleElementReferenceException e) {
        // Espera breve antes de volver a intentar encontrar el elemento
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

        WebElement paginaPrincipal = wait.until(ExpectedConditions.elementToBeClickable(By.id("paginaPrincipal")));
        paginaPrincipal.click();

        WebElement iniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("iniciarSesion")));
        iniciarSesion.click();

        WebElement inputCedula2 = driver.findElement(By.id("cedulaInput"));

        inputCedula2.sendKeys("123456");

        WebElement btnIniciarSesion2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
        btnIniciarSesion2.click(); 


        WebElement verDetallesMascota = wait.until(ExpectedConditions.elementToBeClickable(By.id("verDetalles")));
        verDetallesMascota.click(); 

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombreMascota")));
        WebElement nombreMascota = driver.findElement(By.cssSelector("#nombreMascota span"));
        WebElement razaMascota = driver.findElement(By.cssSelector("#razaMascota span"));
        WebElement edadMascota = driver.findElement(By.cssSelector("#edadMascota span"));
        WebElement enfermedadMascota = driver.findElement(By.cssSelector("#enfermedadMascota span"));
        WebElement duenioMascota = driver.findElement(By.cssSelector("#duenioMascota span"));
        WebElement estadoMascota = driver.findElement(By.cssSelector("#estadoMascota span"));

        String expectedName = "Bobby";
        String expectedRaza = "Golden Retriever";
        String expectedEdad = "3";
        String expectedEnfermedad = "Alergias";
        String duenio = "miguelito";
        String estado = "Activo";

        Assertions.assertThat(nombreMascota.getText()).isEqualTo(expectedName);
        Assertions.assertThat(razaMascota.getText()).isEqualTo(expectedRaza);
        Assertions.assertThat(edadMascota.getText()).isEqualTo(expectedEdad);
        Assertions.assertThat(enfermedadMascota.getText()).isEqualTo(expectedEnfermedad);
        Assertions.assertThat(duenioMascota.getText()).isEqualTo(duenio);
        Assertions.assertThat(estadoMascota.getText()).isEqualTo(estado);
        

        








}

public void segundoCasoDeUso(){

    driver.get("http://localhost:4200/admin/login");

    WebElement inputCedula = driver.findElement(By.id("cedula"));
    WebElement inputPassword = driver.findElement(By.id("password"));

    inputCedula.sendKeys("admin");
    inputPassword.sendKeys("admin");

    WebElement btnIniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
    btnIniciarSesion.click();

    WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard")));
    dashboard.click();

    WebElement tratamientos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numTratamientos")));
    WebElement ventasTotales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ventasTotales")));
    WebElement gananciasTotales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gananciasTotales")));

    int numTratamientos = Integer.parseInt(tratamientos.getText());
    int ventasTotalesx = Integer.parseInt(ventasTotales.getText());
    int gananciasTotalesx = Integer.parseInt(gananciasTotales.getText());

    driver.get("http://localhost:4200/vet/login");

    WebElement inputCedula1 = driver.findElement(By.id("cedula"));
    WebElement inputPassword1 = driver.findElement(By.id("password"));
    
    // Primer intento de inicio de sesión
    inputCedula1.sendKeys("VET123456");
    inputPassword1.sendKeys("pass123");
    WebElement btnIniciarSesion1 = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
    btnIniciarSesion1.click(); 

    WebElement barraBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.id("barraDeBusqueda")));

    barraBusqueda.sendKeys("Pepe");

    WebElement tratamientoBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("tratamiento")));

    tratamientoBtn.click();

    WebElement fecha = wait.until(ExpectedConditions.elementToBeClickable(By.id("fecha")));
    fecha.sendKeys("31-10-2024");


    WebElement selectDroga = driver.findElement(By.id("drogas"));
    Select dropdownDrogas = new Select(selectDroga);

    dropdownDrogas.selectByValue("1");

    WebElement addTratamiento = wait.until(ExpectedConditions.elementToBeClickable(By.id("addTratamiento")));
    addTratamiento.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement barraDeBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("barraDeBusqueda")));
    barraDeBusqueda.sendKeys("Pepe");

    WebElement verDetalles = wait.until(ExpectedConditions.elementToBeClickable(By.id("verDetalles")));
    verDetalles.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombreMascota")));
    List<WebElement> list = driver.findElements(By.cssSelector(".liTratamientoVet"));
    List<WebElement> list2 = driver.findElements(By.cssSelector(".liTratamientoDroga"));
    List<WebElement> list3 = driver.findElements(By.cssSelector(".liTratamientoFecha"));

    String expectedVeterinario = "Dr. Juan Pérez";
    String expectedDroga = "Carprofeno";
    String expectedFecha = "2024-10-31";

    Assertions.assertThat(list.get(0).getText().trim()).isEqualTo(expectedVeterinario);
    Assertions.assertThat(list2.get(0).getText().trim()).isEqualTo(expectedDroga);
    Assertions.assertThat(list3.get(0).getText().trim()).isEqualTo(expectedFecha);


    driver.get("http://localhost:4200/admin/login");

    WebElement inputCedula3 = driver.findElement(By.id("cedula"));
    WebElement inputPassword3 = driver.findElement(By.id("password"));

    inputCedula3.sendKeys("admin");
    inputPassword3.sendKeys("admin");

    WebElement btnIniciarSesion3 = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
    btnIniciarSesion3.click();

    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement dashboard3 = wait3.until(ExpectedConditions.elementToBeClickable(By.id("dashboard")));
    dashboard3.click();

    WebElement tratamientos3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numTratamientos")));
    WebElement ventasTotales3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ventasTotales")));
    WebElement gananciasTotales3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gananciasTotales")));

    int numTratamientosy = Integer.parseInt(tratamientos3.getText());
    int ventasTotalesy = Integer.parseInt(ventasTotales3.getText());
    int gananciasTotalesy = Integer.parseInt(gananciasTotales3.getText());


    Assertions.assertThat(numTratamientosy).isEqualTo(numTratamientos + 1);
    Assertions.assertThat(ventasTotalesy).isEqualTo(ventasTotalesx + 200000);
    Assertions.assertThat(gananciasTotalesy).isEqualTo(gananciasTotalesx + 20000);











}


}
