package com.dante.mcc_customer_service.service.impl;

import com.dante.mcc_customer_service.dto.CustomerDTO;
import com.dante.mcc_customer_service.entity.Customer;
import com.dante.mcc_customer_service.repository.ICustomerRepository;
import com.dante.mcc_customer_service.service.interfaces.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class CustomerServiceimpl implements ICustomerService {

    private ICustomerRepository ICustomerRepository;

    @Override
    public CustomerDTO getByCu(String cu) {
        log.info("Getting customer by CU: {}", cu);
        Optional<Customer> customer = this.ICustomerRepository.findByCu(cu);
        return customer.map(Customer::getDTO).orElseGet(CustomerDTO::new);
    }

    @Override
    public List<CustomerDTO> getAll() {
        return ICustomerRepository.findAll()
                .stream()
                .map(Customer::getDTO)
                .toList();
    }

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        log.info("Adding customer: {}", customerDTO);
        Customer customer = new Customer();
        customer.setData(customerDTO);
        return this.ICustomerRepository.save(customer).getDTO();
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        log.info("Updating customer: {}", customerDTO);
        Optional<Customer> customer = this.ICustomerRepository.findById(customerDTO.getId());
        if (customer.isPresent()) {
            customer.get().setData(customerDTO);
            return this.ICustomerRepository.save(customer.get()).getDTO();
        }
        return null;
    }

    @Override
    public CustomerDTO delete(CustomerDTO customerDTO) {
        log.info("Deleting customer: {}", customerDTO);
        return this.ICustomerRepository.findById(customerDTO.getId())
                .map(customer -> {
                    this.ICustomerRepository.delete(customer);
                    return customer.getDTO();
                })
                .orElse(null);
    }

    @Override
    public CustomerDTO getById(String id) {
        log.info("Getting customer by id: {}", id);
        Optional<Customer> customer = this.ICustomerRepository.findById(id);

        return customer.map(Customer::getDTO).orElseGet(CustomerDTO::new);
    }
}
