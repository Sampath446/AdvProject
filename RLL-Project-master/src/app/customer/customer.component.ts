import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/models/customer';
import { CustomerService } from 'src/services/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  fullname:string='';
  phone:number=0;
  phone2:number=0;
  status:string='';
  address:string='';
  address2:string='';
  email:string='';
  city:string='';
  district:string='';
  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }
  add()
  {
    const customer = new Customer();
    customer.email = this.email;
    customer.fullName = this.fullname;
    customer.phone2 = this.phone2;
    customer.phoneNumber = this.phone;
    customer.address = this.address;
    customer.address2 = this.address2;
    customer.city = this.city;
    customer.district = this.district;
    this.customerService.registerCustomer(customer).subscribe((resp:any)=>{
      alert("customer added");
    })
  }
}
