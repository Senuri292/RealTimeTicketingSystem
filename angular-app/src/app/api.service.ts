import axios from 'axios';

class ApiService {
  addVendor(vendorData: any): Promise<any> {
    return axios.post('http://localhost:8081/api/vendors', vendorData);
  }

  addCustomer(customerData: any): Promise<any> {
    return axios.post('http://localhost:8081/api/customers', customerData);
  }
}

export default new ApiService();
