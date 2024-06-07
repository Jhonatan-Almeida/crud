package com.cds.nicroservicio.companiescrud.repositories;
/**
 * <p> Proyecto companies-crud.
 * <p> Clase CompayRepository 14/5/2024.
 * <p> Copyright 2024 Consejo de la Judicatura.
 * <p> Todos los derechos reservados.
 */

import com.cds.nicroservicio.companiescrud.entities.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA CLASE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - jhonatan.almeida - 14/5/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author jhonatan.almeida
 * @version 1.0.0 $
 * @since 14/5/2024
 */

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

}
