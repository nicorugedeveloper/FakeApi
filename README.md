
# FakeApi

Este proyecto proporciona una API simulada (`FakeApi`) para facilitar el desarrollo de aplicaciones que requieren integración con un backend. La API simula respuestas a las solicitudes de manera consistente para probar las funcionalidades de tu frontend o integrar otros servicios que consumen API.

## Características

- **Simulación de endpoints**: Responde a las solicitudes con datos predefinidos.
- **Configuración simple**: Fácil de desplegar y utilizar en diferentes entornos de desarrollo.
- **Rápido y flexible**: Permite probar funcionalidades del frontend sin necesidad de un backend real.

## Requisitos

- **Java 17** o superior
- **Maven** 3.x
- **Docker** (opcional, si deseas ejecutar la API simulada en un contenedor)

## Instalación

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/nicorugedeveloper/FakeApi.git
   cd FakeApi
   ```

2. **Compila el proyecto**:

   Si utilizas Maven, puedes compilar el proyecto ejecutando:

   ```bash
   mvn clean install
   ```

3. **Ejecuta la API**:

   Para ejecutar la API localmente:

   ```bash
   mvn spring-boot:run
   ```

4. **Acceso a la API**:

   La API estará disponible en `http://localhost:8080`.


