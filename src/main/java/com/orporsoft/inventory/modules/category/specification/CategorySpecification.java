package com.orporsoft.inventory.modules.category.specification;

import org.springframework.data.jpa.domain.Specification;

import com.orporsoft.inventory.modules.category.entity.Category;

public class CategorySpecification {

    public static Specification<Category> keyword(String keyword){

        return (root,query,cb)->{

            if(keyword==null||keyword.isBlank()){
                return cb.conjunction();
            }

            String like="%"+keyword.toLowerCase()+"%";

            return cb.or(
                    cb.like(cb.lower(root.get("code")),like),
                    cb.like(cb.lower(root.get("name")),like)
            );

        };

    }

    public static Specification<Category> status(String status){

        return (root,query,cb)->{

            if(status==null||status.isBlank()){
                return cb.conjunction();
            }

            return cb.equal(root.get("status"),status);

        };

    }

}