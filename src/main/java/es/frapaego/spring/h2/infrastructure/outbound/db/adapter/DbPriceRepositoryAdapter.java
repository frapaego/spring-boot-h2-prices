package es.frapaego.spring.h2.infrastructure.outbound.db.adapter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.model.Price;
import es.frapaego.spring.h2.domain.repository.PriceRepository;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.PriceDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataPriceRepository;

/**
 * Adapter que implementa el `PriceRepository` del dominio usando Spring Data JPA.
 * Implementa una versión eficiente que solicita solo el primer resultado ordenado por `priority`.
 */
@Primary
@Component
public class DbPriceRepositoryAdapter implements PriceRepository {

    @Autowired
    private SpringDataPriceRepository springDataPriceRepository;

    @Autowired
    private GenericConversionService genericConversionService;

    @Override
    public Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
            final Brand brand) {
        // Convertir Brand a BrandDAO
        final BrandDAO brandDAO = this.genericConversionService.convert(brand, BrandDAO.class);
        if (brandDAO == null) {
            return null;
        }
        // Pedimos solo la primera página con 1 elemento, ordenada por priority DESC
        final List<PriceDAO> results = this.springDataPriceRepository.findByStartDateAndProductIdAndBrandIdOrderByPriorityDesc(startDate, productId, brandDAO, PageRequest.of(0, 1));
        if (results == null || results.isEmpty()) {
            return null;
        }
        final PriceDAO p = results.get(0);
        return this.genericConversionService.convert(p, Price.class);
    }

}
