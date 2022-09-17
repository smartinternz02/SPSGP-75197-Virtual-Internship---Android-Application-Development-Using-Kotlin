package com.example.grocerylist.UI

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerylist.Database.Entity.GroceryItems
import com.example.grocerylist.R
import kotlinx.android.synthetic.main.grocerydialog.*

class GroceryItemDialog(context: Context,var dialogListener: DialogListener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.grocerydialog)

        tvSave.setOnClickListener {

            val name = etItemName.text.toString()
            val quantity = etItemQuantity.text.toString()
            val price = etItemPrice.text.toString()

            if (name.isEmpty() || quantity.isEmpty() || price.isEmpty()){
                Toast.makeText(context,"Please enter all the details...",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val item = GroceryItems(name , quantity.toInt() , price.toInt())
                dialogListener.onAddButtonClicked(item)
                Toast.makeText(context,"Item inserted...",Toast.LENGTH_SHORT).show()
                dismiss()
            }

        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}