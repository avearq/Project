package com.example.satellite.coffeeshop;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Satellite on 7/3/2558.
 */
public class Order extends Activity implements View.OnClickListener{
//variable for Menu
    private String NameMenu ,TypeMenu;
    private int PriceMenu,idMenu,TaxMenu ;
    private Spinner Table_spin;


    Button B_cencal,B_ok,B_OIcoffee,B_OHcoffee;

    Button B_Plus,B_Remove;

    TextView Tresult_table,T_Otextview,T_Otextview2,T_Otextview3,T_Otextview4,T_Otextview5;
    String a[]={"Iced Cappuccino","Iced Cafe' Latte","Iced Mocha"," Iced Coffee","Iced Caramel"};
    String hot[]={" Hot Coffee","Hot Choocolate","Hot Milk "," Cappuccino","Coffee Mocha"};
    EditText E_OTable;
    String SOTble_number;
    int  ITable_number,plus_amount;
    int  D_plus_amount,D_plus_amountt;
    boolean test;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
//======================= DropdowList  ===============================
        Table_spin = (Spinner) findViewById(R.id.Table_spin);
        List<Integer> list = new ArrayList<Integer>();
        for( i=1;i<=20;i++){
        //list.add("Select Table");
        list.add(i);
    }
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        Table_spin.setAdapter(dataAdapter);
//=======================End DropdowList  =============================
     //   B_cencal = (Button) findViewById(R.id.B_cancel);
       //     B_cencal.setOnClickListener(this);
        B_ok = (Button) findViewById(R.id.B_ok);
                B_ok.setOnClickListener(this);
     //   E_OTable = (EditText) findViewById(R.id.E_table);
           //     E_OTable.setOnClickListener(this);

        B_OIcoffee = (Button) findViewById(R.id.B_order_Icoffee);
             B_OIcoffee.setOnClickListener(this);
        B_OHcoffee=  (Button) findViewById(R.id.B_order_Hcoffee);
            B_OHcoffee.setOnClickListener(this);
/*
        B_Plus = (Button) findViewById(R.id.B_plus);
            B_Plus.setOnClickListener(this);
        B_Remove = (Button) findViewById(R.id.B_remove);
            B_Remove.setOnClickListener(this);

*/
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.B_order_Icoffee:
               // a.setText("");
                //int size=a.length;
               // for (int i = 0; i <1; i++) {
                   // System.out.println(a[i]);
                 /*   T_Otextview = (TextView) findViewById(R.id.textView);
                    T_Otextview.setText("  "+a[0]);
                    T_Otextview2 = (TextView) findViewById(R.id.textView2);
                    T_Otextview2.setText("  "+a[1]);
                    T_Otextview3 = (TextView) findViewById(R.id.textView3);
                    T_Otextview3.setText("  "+a[2]);
                    T_Otextview4 = (TextView) findViewById(R.id.textView4);
                    T_Otextview4.setText("  "+a[3]);
                    T_Otextview5 = (TextView) findViewById(R.id.textView5);
                    T_Otextview5.setText("  "+a[4]);
                    */

              final  Button  B_item = (Button) findViewById(R.id.item_button);
                B_item.setText("  "+a[4]+"\n$15");
                B_item.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        D_plus_amountt = D_plus_amountt + 1;
                        B_item.setText("  "+a[4]+"\n$15"+"\nx "+ D_plus_amountt );

                    }
                });
                Button  B_item1 = (Button) findViewById(R.id.item_button2);
                B_item1.setText("  "+a[1]+"\n$20");
             // }

                break;
            case R.id.B_order_Hcoffee:
               /* T_Otextview = (TextView) findViewById(R.id.textView);
                T_Otextview.setText("  "+hot[0]);
                T_Otextview2 = (TextView) findViewById(R.id.textView2);
                T_Otextview2.setText("  "+hot[1]);
                T_Otextview3 = (TextView) findViewById(R.id.textView3);
                T_Otextview3.setText("  "+hot[2]);
                T_Otextview4 = (TextView) findViewById(R.id.textView4);
                T_Otextview4.setText("  "+hot[3]);
                T_Otextview5 = (TextView) findViewById(R.id.textView5);
                T_Otextview5.setText("  "+hot[4]);
               */



                final Button  B_item3 = (Button) findViewById(R.id.item_button);
                B_item3.setText("  "+hot[2]+"\n$25");
                B_item3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        D_plus_amount = D_plus_amount + 1;
                        B_item3.setText("  "+hot[2]+"\n$25"+"\nx "+ D_plus_amount );
                    }
                });
                Button  B_item4 = (Button) findViewById(R.id.item_button2);
                B_item4.setText("  "+hot[1]+"\n$25");

                break;

         /*   case R.id.B_plus:
                SOTble_number = E_OTable.getText().toString();
                try {
                D_plus_amount = Integer.parseInt(SOTble_number);
                test = true;
                 } catch (NumberFormatException e) {
            test = false;
                }
                if (test == true) {
                    D_plus_amount = D_plus_amount + 1;
                    E_OTable.setText("" + D_plus_amount );
                }
                else {
                    D_plus_amount = D_plus_amount + 1;
                    E_OTable.setText("" + D_plus_amount );
                }
                break;
            case R.id.B_remove:
                SOTble_number = E_OTable.getText().toString();
                try {
                    D_plus_amount = Integer.parseInt(SOTble_number);
                    test = true;
                } catch (NumberFormatException e) {
                    test = false;
                }
                if (test == true) {
                    D_plus_amount = D_plus_amount - 1;
                    E_OTable.setText("" + D_plus_amount );
                }
                else {
                   /* if not number show error
                    Toast.makeText(Order.this, R.string.notnum,
                            Toast.LENGTH_SHORT).show();
                }
                break; */

        /*    case R.id.B_cancel:
                Intent m1 = new Intent(this,MainActivity.class);
                startActivity(m1);
                break;   */
            case R.id.B_ok:  //confirm order
                TextView result_Table_amount;

              //  TextView t=(TextView) findViewById(R.id.Number_PTaable);
          //  final  DecimalFormat changeFormat = new DecimalFormat("#,###,###,###");
            //    t.setText(" " +a[1]);

              /*    SOTble_number = E_OTable.getText().toString();
                ITable_number = Integer.parseInt(SOTble_number);
                Tresult_table.setText(" " + changeFormat.format(ITable_number));

                TextView t=(TextView) findViewById(R.id.Number_PTaable);
                t.setText(" " + i);
              */
                Intent m2 = new Intent(this,Payin.class);
                startActivity(m2);
                break;
        }

    }


     /* @Override
    protected void onCreate(Bundle Top5Linux) {
        super.onCreate(Top5Linux);
       // setContentView(R.layout.activity_order);
        String linux[] = new String[] {"coffee","iea" ,"ww","qq","qwe","asdas","qweqwq","q2ewqe","qweqweqw","qweqweqw"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,linux);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
    String item = (String)getListAdapter().getItem(position);
        Toast.makeText(this,item+"Interesting OS",Toast.LENGTH_LONG).show();

    }
*/
    public Order(){

    }

    public  Order(int idMenu,String NameMenu ,int PriceMenu ,int TaxMenu,String TypeMenu){
        this.idMenu=idMenu;
        this.NameMenu=NameMenu;
        this.PriceMenu=PriceMenu;
        this.TaxMenu=TaxMenu;
        this.TypeMenu=TypeMenu;



    }
    //Database
    public static final String DATABASE_NAME = "Coffee.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "Menu";

    public class Column {
        public static final String ID= BaseColumns._ID;
        public static final String NameMenu = "NameMenu";
        public static final String PriceMenu = "PriceMenu";
        public static final String TaxMenu = "TaxMenu";
        public static final String TypeMenu = "TypeMenu";

    }

}
