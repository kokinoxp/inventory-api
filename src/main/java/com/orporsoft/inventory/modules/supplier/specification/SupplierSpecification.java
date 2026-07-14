package com.orporsoft.inventory.modules.supplier.specification;

import com.orporsoft.inventory.modules.supplier.entity.Supplier;
import org.springframework.data.jpa.domain.Specification;

public class SupplierSpecification {

    public static Specification<Supplier> keyword(String keyword) {

        return (root, query, cb) -> {

            if (keyword == null || keyword.isBlank()) {
                return cb.conjunction();
            }

            String like = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("code")), like),
                    cb.like(cb.lower(root.get("name")), like),
                    cb.like(cb.lower(root.get("contactName")), like),
                    cb.like(cb.lower(root.get("phone")), like),
                    cb.like(cb.lower(root.get("email")), like)
            );
        };
    }

    public static Specification<Supplier> status(String status) {

        return (root, query, cb) -> {

            if (status == null || status.isBlank()) {
                return cb.conjunction();
            }

            return cb.equal(root.get("status"), status);
        };
    }

}