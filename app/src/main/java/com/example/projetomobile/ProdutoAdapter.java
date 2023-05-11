package com.example.projetomobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projetomobile.dao.model.Produto;

import java.util.ArrayList;


public class ProdutoAdapter extends ArrayAdapter<Produto> {

    public ProdutoAdapter(Context context, ArrayList<Produto> prod) {
        super(context, R.layout.item_produto, prod);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position

        Produto prod = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_produto, parent, false);

        }

        // Lookup view for data population

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_prod);
        TextView tvValor = (TextView) convertView.findViewById(R.id.tv_valor_prod);
        TextView tvQtd = (TextView) convertView.findViewById(R.id.tv_qtd_prod);

        // Populate the data into the template view using the data object

        tvName.setText(prod.getNome());
        tvQtd.setText("Quantidade: "+prod.getQuantidade().toString());
        tvValor.setText("R$ "+String.valueOf(prod.getValor()));

        // Return the completed view to render on screen

        return convertView;

    }
}
