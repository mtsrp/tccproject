package com.software.engenharia.gerenc_fazenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.software.engenharia.gerenc_fazenda.Funcionario.tab;

import java.util.ArrayList;
import java.util.List;

class CardArrayAdapter extends ArrayAdapter<tab> {
    //Instanciação do Array da lista.
    private List<tab> cardList = new ArrayList<tab>();

    //Declaração das variavéis de cada item da lista.
    static class CardViewHolder {
        TextView line1;
        TextView line2;
        TextView line3;
    }

    public CardArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    //Definição do posicionamento e do conteúdo do CardArrayAdapter, que dará o visual da ListView.
    @Override
    public void add(tab object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public tab getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_personalizada, parent, false);
            viewHolder = new CardViewHolder();
            viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
            viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
            viewHolder.line3 = (TextView) row.findViewById(R.id.line3);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CardViewHolder)row.getTag();
        }
        tab card = getItem(position);

        //Setters das informações dos cards, de acordo com a pesquisa feita e os dados que serão retornados.
        viewHolder.line1.setText(card.getNOME_FUNC().replace("_", " "));
        viewHolder.line2.setText(card.getDTADMI_FUNC());
        viewHolder.line3.setText(card.getUSUARIO_FUNC());

        return row;
    }


}

