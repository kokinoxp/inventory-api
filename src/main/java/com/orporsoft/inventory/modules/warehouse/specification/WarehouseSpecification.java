package com.orporsoft.inventory.modules.warehouse.specification;

import com.orporsoft.inventory.modules.warehouse.entity.Warehouse;
import org.springframework.data.jpa.domain.Specification;

public class WarehouseSpecification {

    public static Specification<Warehouse> keyword(String keyword) {

        return (root, query, cb) -> {

            if (keyword == null || keyword.isBlank()) {
                return cb.conjunction();
            }

            String like = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("code")), like),
                    cb.like(cb.lower(root.get("name")), like),
                    cb.like(cb.lower(root.get("location")), like)
            );

        };

    }

    public static Specification<Warehouse> status(String status) {

        return (root, query, cb) -> {

            if (status == null || status.isBlank()) {
                return cb.conjunction();
            }

            return cb.equal(root.get("status"), status);

        };

    }

}