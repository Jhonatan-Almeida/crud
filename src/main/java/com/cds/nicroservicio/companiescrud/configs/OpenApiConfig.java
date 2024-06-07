package com.cds.nicroservicio.companiescrud.configs;
/**
 * <p> Proyecto companies-crud.
 * <p> Clase OpenApiConfig 29/5/2024.
 * <p> Copyright 2024 Consejo de la Judicatura.
 * <p> Todos los derechos reservados.
 */

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA CLASE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - jhonatan.almeida - 29/5/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author jhonatan.almeida
 * @version 1.0.0 $
 * @since 29/5/2024
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "companies CRUD",
                version = "1.0.0",
                description = "This is a CRUD for the management companies"
        )
)
public class OpenApiConfig {

}
