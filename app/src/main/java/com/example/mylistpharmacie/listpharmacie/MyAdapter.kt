package com.example.mylistpharmacie.listpharmacie


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistpharmacie.R
import com.example.mylistpharmacie.db.Pharmacie

class MyAdapter(val context: FragmentActivity?, var data:List<Pharmacie>):RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.info_pharmacie, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.name.text = data[position].name
            holder.address.text = data[position].address
            holder.phone.text = data[position].phone


        holder.item.setOnClickListener {

            val pharmacy = Pharmacie()
            pharmacy.name= data[position].name
            pharmacy.address = data[position].address
            pharmacy.phone =data[position].phone

            var bundle = bundleOf("pharmacy" to pharmacy)

            context?.findNavController(R.id.myNavHostFragment)?.navigate(R.id.action_listPharmacieFragment_to_pharmacieFragment,bundle)

        }


    }


}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val item = view.findViewById<View>(R.id.itemInfo) as View

    val name = view.findViewById<TextView>(R.id.NameVar) as TextView
    val phone = view.findViewById<TextView>(R.id.phoneVar) as TextView
    val address = view.findViewById<TextView>(R.id.adressVar) as TextView

}

