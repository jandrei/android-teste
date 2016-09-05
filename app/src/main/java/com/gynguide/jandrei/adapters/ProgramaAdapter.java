package com.gynguide.jandrei.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gynguide.jandrei.CicloActivity;
import com.gynguide.jandrei.R;
import com.gynguide.jandrei.model.Programa;
import com.gynguide.jandrei.util.Mensagem;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jandrei on 02/09/16.
 */
public class ProgramaAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    Context context;
    int id;
    List<Programa> lista = null;

    public ProgramaAdapter(Context context, int resource, List<Programa> lista) {
        super(context, resource, lista);
        try {
            this.context = context;
            this.id = resource;
            this.lista = lista;
        } catch (Exception e) {
            Mensagem.erro(context, e);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
//        Carro carro;
//        ImageView foto;
        TextView nome;
//        TextView dono;
//        Bitmap raw;
//        byte[] fotoArray;
        Programa programa = null;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(id, parent, false);
        }

        nome = (TextView) view.findViewById(R.id.id_text_view);
//        dono = (TextView)view.findViewById(R.id.textView3);
//        foto = (ImageView)view.findViewById(R.id.imageView);

        programa = lista.get(position);

        nome.setText("< " + programa.getTxtPrograma() + " >");
//        dono.setText(carro.getDono());
//        fotoArray = carro.getFoto();

//        if(fotoArray!=null){
//            raw  = BitmapFactory.decodeByteArray(fotoArray,0,fotoArray.length);
//            foto.setImageBitmap(raw);
//        }

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Mensagem.mensagem(this.context, lista.get(position));

        Logger.getAnonymousLogger().info("teste");

        Intent i = new Intent(this.context, CicloActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.context.startActivity(i);

    }
}

