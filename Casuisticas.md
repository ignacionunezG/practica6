## Pruebas realizadas:
#### DNI:
- 1. Probar 6 DNIs con estructuras erróneas y verificar que se devuelve un FALSE indicando que no son válidos
- 2. Probar 3 DNIs con estructuras correctas y verificar que se devuelve un TRUE indicando que es válido

#### Teléfono:
- 1. Probar 4 DNIs con estructuras erróneas y verificar que se devuelve un FALSE indicando que no son válidos
- 2. Probar 4 DNIs con estructuras correctas y verificar que se devuelve un TRUE indicando que es válido

#### ProcessController:
- 1. Se introduce unos datos correctamente (Nombre, DNI y Teléfono), y se verifica que el post se realiza correctamente recibiendo las respuesta esperada del endpoint legacy (un mnesaje indicando que todo ha ido bien) y un HTTP status de 200.
- 2. Se introduce unos datos incorrectamente (Nombre, DNI y Teléfono), y se verifica que el post se realiza incorrectamente recibiendo las respuesta esperada del endpoint legacy (un mnesaje indicando que no ha ido bien) y un HTTP status de 200.
- 3. Se introduce unos datos correctamente (Nombre, DNI y Teléfono), y se verifica que el post se realiza correctamente recibiendo un mensaje de OK y un HTTP status de 200 .
- 4. Se introduce unos datos correctamente (Nombre, DNI y Teléfono), y se verifica que el post se realiza correctamente recibiendo un mensaje de OK y un HTTP status de 200.
