import { Component, OnInit } from '@angular/core';
import { Sales } from 'src/models/sales';
import { SaleService } from 'src/services/sales.service';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {

  itemName:string='';
  itemNumber:String='';
  quantity:string='';
  customerName:string='';
  customerId:string='';
  unityPrice:string='';
  totalStock:string='';
  saleId:string='';
  discount:string='';
  saleDate:string='';

  sale={}as Sales;
  constructor(private saleservice:SaleService) { }

  ngOnInit(): void {
  }
    alertbar()
   {

    this.sale.itemName=this.itemName;
    this.sale.itemNumber=this.itemNumber;
    this.sale.quantity=this.quantity;
    this.sale.customerName=this.customerName;
    this.sale.customerId=this.customerId;
    this.sale.unityPrice=this.unityPrice;
    this.sale.totalStock=this.totalStock;
    this.sale.discount=this.discount;
    this.sale.saleDate=this.saleDate;
    this.saleservice.registerSale(this.sale).subscribe((resp:any)=>{
      alert("Products added");

  })

  }
}
