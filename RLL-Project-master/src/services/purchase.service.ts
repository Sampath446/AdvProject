import { Customer } from 'src/models/customer';
import { Purchase } from 'src/models/purchase';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PurchaseService {
  private customerLoggedIn : any;
  private regCustomerUrl: string =
  'http://localhost:8080/api/v1/Purchase';
  private logCustomerUrl: string = 'http://localhost:8080/api/v1/Purchase';



  constructor(private _httpClient: HttpClient) {}

  registerPurchase(purchase: Purchase): any {
    console.log(purchase)
    return this._httpClient.post<Purchase>(this.regCustomerUrl, purchase);

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
