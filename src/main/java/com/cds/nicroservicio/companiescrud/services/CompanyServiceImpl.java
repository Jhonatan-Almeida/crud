package com.cds.nicroservicio.companiescrud.services;
/**
 * <p> Proyecto companies-crud.
 * <p> Clase CompanyServiceImpl 14/5/2024.
 * <p> Copyright 2024 Consejo de la Judicatura.
 * <p> Todos los derechos reservados.
 */


import com.cds.nicroservicio.companiescrud.entities.Category;
import com.cds.nicroservicio.companiescrud.entities.Company;
import com.cds.nicroservicio.companiescrud.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(webSite -> {
            if (Objects.isNull(webSite.getCategory())){
                webSite.setCategory(Category.NONE);
            }
        });
        return this.companyRepository.save(company);
    }

    @Override
    public Company readByName(String name) {
        return this.companyRepository.findByName(name).
                orElseThrow(()->new NoSuchElementException("Companía no encontrada"));
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = this.companyRepository.findByName(name)
                .orElseThrow(()->new NoSuchElementException("Compania no encontrada"));
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setFounder(company.getFounder());
        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete = this.companyRepository.findByName(name)
                .orElseThrow(()->new NoSuchElementException("Compania no encontrada"));
        this.companyRepository.delete(companyToDelete);
    }
}
