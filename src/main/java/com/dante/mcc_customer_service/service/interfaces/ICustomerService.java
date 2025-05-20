package com.dante.mcc_customer_service.service.interfaces;

import com.dante.mcc_customer_service.dto.CustomerDTO;
import com.dante.mcc_customer_service.utils.ICrud;

public interface ICustomerService extends ICrud<CustomerDTO> {

    CustomerDTO getByCu(String cu);
}
