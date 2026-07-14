package com.orporsoft.inventory.modules.supplier.service;

import com.orporsoft.inventory.modules.supplier.dto.request.SupplierRequest;
import com.orporsoft.inventory.modules.supplier.dto.response.SupplierResponse;

import java.util.List;

public interface SupplierService {

    SupplierResponse create(SupplierRequest request);

    SupplierResponse update(Long id, SupplierRequest request);

    SupplierResponse findById(Long id);

    List<SupplierResponse> findAll();

    void delete(Long id);

}