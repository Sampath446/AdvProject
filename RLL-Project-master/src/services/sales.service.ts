import { Customer } from 'src/models/customer';
import { Sales } from 'src/models/sales';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SaleService {
  private customerLoggedIn : any;
  private regCustomerUrl: string =
  'http://localhost:8080/api/v1/sales';
  private logCustomerUrl: string = 'http://localhost:8080/api/v1/user';



  constructor(private _httpClient: HttpClient) {}

  registerSale(sale: Sales): any {
    return this._httpClient.post<Customer>(this.regCustomerUrl, sale);
  }

  validateCustomer(value: any) {
    return this._httpClient.post<Customer>(this.logCustomerUrl, value);
  }

  setCustomerLoggedIn(customerLoggedIn: string) {
    this.customerLoggedIn = customerLoggedIn;
  }
  getCustomerLoggedIn() {
    return this.customerLoggedIn;
  }
}
