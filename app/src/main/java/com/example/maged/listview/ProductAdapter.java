package com.example.maged.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

   ArrayList<Product> products = new ArrayList<Product>();

   void addProduct(String name, String price, int image)
   {
      Product product = new Product(name, price, image);
      products.add(product);
   }

   void removeProduct(int position)
   {
      products.remove(position);
   }

   @Override
   public int getCount() {
      return products.size();
   }

   @Override
   public Object getItem(int i) {
      return products.get(i);
   }

   @Override
   public long getItemId(int i) {
      return i;
   }

   @Override
   public View getView(int i, View view, final ViewGroup viewGroup) {
      final int currentPosition = i;

      if(view == null) {
         LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
         final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.product_item, null, false);

         TextView name = (TextView) layout.findViewById(R.id.txtProductName);
         TextView price = (TextView) layout.findViewById(R.id.txtProductPrice);
         final ImageView productImageSmall = (ImageView) layout.findViewById(R.id.imgProductSmall);


         name.setText(products.get(i).getName());
         price.setText(products.get(i).getPrice());
         productImageSmall.setImageResource(products.get(i).getImage());



         return layout;
      }

      return view;
   }
}