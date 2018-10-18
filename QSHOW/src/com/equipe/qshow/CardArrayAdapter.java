package com.equipe.qshow;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CardArrayAdapter  extends ArrayAdapter<tab> {

	//Instanciação do Array da lista.
    private List<tab> cardList = new ArrayList<tab>();

    //Declaração das variavéis de cada item da lista.
    static class CardViewHolder {
    	ImageView imagem;
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
            viewHolder.imagem = (ImageView) row.findViewById(R.id.imagem);
            viewHolder.line1 = (TextView) row.findViewById(R.id.line1);
            viewHolder.line2 = (TextView) row.findViewById(R.id.line2);
            viewHolder.line3 = (TextView) row.findViewById(R.id.line3);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CardViewHolder)row.getTag();
        }
        tab card = getItem(position);
        
   		//Setters das informações dos cards, de acordo com a pesquisa feita e os dados que serão retornados.
        viewHolder.line1.setText(card.getNOME_ARTISTA().replace("_", " "));
        viewHolder.line2.setText(card.getDATA_SHOW());
        viewHolder.line3.setText(card.getLOCAL_SHOW());
        
   		if (card.getFOTO_ARTISTA().equals("aha")){
  			 viewHolder.imagem.setImageResource(R.drawable.aha);
  		}
   		if (card.getFOTO_ARTISTA().equals("alok")){
  			 viewHolder.imagem.setImageResource(R.drawable.alok);
  		}
   		if (card.getFOTO_ARTISTA().equals("cidadenegra")){
  			 viewHolder.imagem.setImageResource(R.drawable.cidadenegra);
  		}
   		if (card.getFOTO_ARTISTA().equals("cpm")){
  			 viewHolder.imagem.setImageResource(R.drawable.cpm);
  		}
   		if (card.getFOTO_ARTISTA().equals("deftones")){
  			 viewHolder.imagem.setImageResource(R.drawable.deftones);
  		}
   		if (card.getFOTO_ARTISTA().equals("delatierra")){
  			 viewHolder.imagem.setImageResource(R.drawable.delatierra);
  		}
   		if (card.getFOTO_ARTISTA().equals("eltonjohn")){
  			 viewHolder.imagem.setImageResource(R.drawable.eltonjohn);
  		}
   		if (card.getFOTO_ARTISTA().equals("faithnomore")){
  			 viewHolder.imagem.setImageResource(R.drawable.faithnomore);
  		}
   		if (card.getFOTO_ARTISTA().equals("felguk")){
  			 viewHolder.imagem.setImageResource(R.drawable.felguk);
  		}
   		if (card.getFOTO_ARTISTA().equals("gojira")){
  			 viewHolder.imagem.setImageResource(R.drawable.gojira);
  		}
   		if (card.getFOTO_ARTISTA().equals("hollywoodvampires")){
  			 viewHolder.imagem.setImageResource(R.drawable.hollywoodvampires);
  		}
   		if (card.getFOTO_ARTISTA().equals("johnlegend")){
  			 viewHolder.imagem.setImageResource(R.drawable.johnlegend);
  		}
   		if (card.getFOTO_ARTISTA().equals("katyperry")){
  			 viewHolder.imagem.setImageResource(R.drawable.katyperry);
  		}
   		if (card.getFOTO_ARTISTA().equals("korn")){
  			 viewHolder.imagem.setImageResource(R.drawable.korn);
  		}
   		if (card.getFOTO_ARTISTA().equals("lambofgod")){
  			 viewHolder.imagem.setImageResource(R.drawable.lambofgod);
  		}
   		if (card.getFOTO_ARTISTA().equals("lulusantos")){
  			 viewHolder.imagem.setImageResource(R.drawable.lulusantos);
  		}
   		if (card.getFOTO_ARTISTA().equals("magic")){
  			 viewHolder.imagem.setImageResource(R.drawable.magic);
  		}
   		if (card.getFOTO_ARTISTA().equals("mastodon")){
  			 viewHolder.imagem.setImageResource(R.drawable.mastodon);
  		}
   		if (card.getFOTO_ARTISTA().equals("metallica")){
  			 viewHolder.imagem.setImageResource(R.drawable.metallica);
  		}
   		if (card.getFOTO_ARTISTA().equals("motleycrue")){
  			 viewHolder.imagem.setImageResource(R.drawable.motleycrue);
  		}
   		if (card.getFOTO_ARTISTA().equals("onerepublic")){
  			 viewHolder.imagem.setImageResource(R.drawable.onerepublic);
  		}
   		if (card.getFOTO_ARTISTA().equals("paralamasdosucesso")){
  			 viewHolder.imagem.setImageResource(R.drawable.paralamasdosucesso);
  		}
   		if (card.getFOTO_ARTISTA().equals("queen")){
  			 viewHolder.imagem.setImageResource(R.drawable.queen);
  		}
   		if (card.getFOTO_ARTISTA().equals("queensofthestoneage")){
  			 viewHolder.imagem.setImageResource(R.drawable.queensofthestoneage);
  		}
   		if (card.getFOTO_ARTISTA().equals("rihanna")){
  			 viewHolder.imagem.setImageResource(R.drawable.rihanna);
  		}
   		if (card.getFOTO_ARTISTA().equals("robyn")){
  			 viewHolder.imagem.setImageResource(R.drawable.robyn);
  		}
   		if (card.getFOTO_ARTISTA().equals("rodstewart")){
  			 viewHolder.imagem.setImageResource(R.drawable.rodstewart);
  		}
   		if (card.getFOTO_ARTISTA().equals("royalblood")){
  			 viewHolder.imagem.setImageResource(R.drawable.royalblood);
  		}
   		if (card.getFOTO_ARTISTA().equals("samsmith")){
  			 viewHolder.imagem.setImageResource(R.drawable.samsmith);
  		}
   		if (card.getFOTO_ARTISTA().equals("sheppard")){
  			 viewHolder.imagem.setImageResource(R.drawable.sheppard);
  		}
   		if (card.getFOTO_ARTISTA().equals("slipknot")){
  			 viewHolder.imagem.setImageResource(R.drawable.slipknot);
  		}
   		if (card.getFOTO_ARTISTA().equals("systemofadown")){
  			 viewHolder.imagem.setImageResource(R.drawable.systemofadown);
  		}
   		if (card.getFOTO_ARTISTA().equals("thescript")){
  			 viewHolder.imagem.setImageResource(R.drawable.thescript);
  		}
   		if (card.getFOTO_ARTISTA().equals("tropkillaz")){
  			 viewHolder.imagem.setImageResource(R.drawable.tropkillaz);
  		}      
        
        return row;
    }

    public Bitmap Bitmap (byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
