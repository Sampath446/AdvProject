import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/models/customer';
import {Purchase} from 'src/models/purchase';
import { PurchaseService } from 'src/services/purchase.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {

    itemName:string='';
    itemNumber:String='';
    quantity:string='';
	  vendorName:string='';
    purchaseId:string='';
    unityPrice:string='';
	  currentStock:string='';
	  saleDate:string='';
   totalCost:string='';
    purchase={}as Purchase;
  constructor(private purchaseservice:PurchaseService) { }

  ngOnInit(): void {
  }
  alertbar()

  {

   this.purchase.itemName =this.itemName;
   this.purchase.itemNumber =this.itemNumber;
   this.purchase.quantity =this.quantity;
   this.purchase.vendorName=this.vendorName;
   this.purchase.purchaseId=this.purchaseId;
   this.purchase.unityPrice=this.unityPrice;
   this.purchase.currentStock=this.currentStock;
   this.purchase.saleDate=this.saleDate;
   this.purchase.totalCost=this.totalCost;
   this.purchaseservice.registerPurchase(this.purchase).subscribe((resp:any)=>{
      alert("Purchase added");
    })


}
}
