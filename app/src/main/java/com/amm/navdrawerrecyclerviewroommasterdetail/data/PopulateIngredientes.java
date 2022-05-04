package com.amm.navdrawerrecyclerviewroommasterdetail.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.Guisos;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.GuisosDao;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.TiposGuisos;
import com.amm.navdrawerrecyclerviewroommasterdetail.guisos.TiposGuisosDao;
import com.amm.navdrawerrecyclerviewroommasterdetail.ingrediente.Ingrediente;
import com.amm.navdrawerrecyclerviewroommasterdetail.ingrediente.IngredienteDao;

import java.util.List;

public class PopulateIngredientes implements Runnable {
    private AppRoomDatabase INSTANCE;

    public PopulateIngredientes(AppRoomDatabase instance) {
        INSTANCE = instance;
    }

    @Override
    public void run() {
        // Populate the database in the background.
        // If you want to start with more words, just add them.
        IngredienteDao ingredienteDao = INSTANCE.ingredienteDao();
        //dao.deleteAll();
        //Añadimos ingredientes por defecto al crear la base de datos.
        Ingrediente ingrediente = new Ingrediente("Leche");
        ingredienteDao.insert(ingrediente);

        ingrediente = new Ingrediente("Canela");
        ingredienteDao.insert(ingrediente);

        //---------------------------------------------------------

//
//        //Añadimos los tipos de Guisos básicos al crear la base de datos.
//        TiposGuisosDao tiposGuisosDao = INSTANCE.tiposGuisosDao();
//        TiposGuisos tiposGuisos = new TiposGuisos(TiposGuisos.GUISOS_DE_CARNE);
//        tiposGuisosDao.insert(tiposGuisos);
//
//        tiposGuisos = new TiposGuisos(TiposGuisos.GUISOS_DE_PESCADO);
//        tiposGuisosDao.insert(tiposGuisos);
//
//        tiposGuisos = new TiposGuisos(TiposGuisos.GUISOS_DE_VERDURA);
//        tiposGuisosDao.insert(tiposGuisos);

//        //---------------------------------------------------------
//
//        //Añadimos algunos Guisos al crear la base de datos
//        GuisosDao guisosDao = INSTANCE.guisosDao();
//        //De Carne
//        //Integer deCarne = tiposGuisosDao.getTipoId(TiposGuisos.GUISOS_DE_CARNE).getValue();
//        tiposGuisos = tiposGuisosDao.getTipoGuisos(TiposGuisos.GUISOS_DE_CARNE).getValue();
//        guisosDao.insert(new Guisos("Caldereta de cordero con patatas",tiposGuisos.getId()));
////        guisosDao.insert(new Guisos("Caldereta de cordero con patatas",tiposGuisosDao.getTipoId(TiposGuisos.GUISOS_DE_CARNE).getValue()));
////        guisosDao.insert(new Guisos("Caldereta de cordero con patatas",1));
////        guisosDao.insert(new Guisos("Caldereta de cordero con tomate",deCarne));
////        guisosDao.insert(new Guisos("Cazuela de costilla con cardo",deCarne));
////        guisosDao.insert(new Guisos("Ossobuco con puré de boniato",deCarne));
////        guisosDao.insert(new Guisos("Guisote de ternera con patatas",deCarne));
////        guisosDao.insert(new Guisos("Guiso de cordero marroquí",deCarne));
////        guisosDao.insert(new Guisos("Guiso de cordero con hongos",deCarne.getValue()));
////        guisosDao.insert(new Guisos("Guiso de vaca a la cerveza negra",deCarne.getValue()));
////        guisosDao.insert(new Guisos("Guiso de cerdo con almejas",deCarne.getValue()));
////        guisosDao.insert(new Guisos("Conejo guisado con ciruelas",deCarne.getValue()));
////        guisosDao.insert(new Guisos("Conejo al curry con arroz frito",deCarne.getValue()));
////        guisosDao.insert(new Guisos("Conejo en salsa con frutas pasas",deCarne.getValue()));
//        //De Pescado
//        guisosDao.insert(new Guisos("Caldereta de sepia",tiposGuisosDao.getTipoId(TiposGuisos.GUISOS_DE_PESCADO).getValue()));
//        //guisosDao.insert(new Guisos("Merluza con salsa de piquillos",dePescado));
////        guisosDao.insert(new Guisos("Calamares en salsa verde",dePescado.getValue()));
////        guisosDao.insert(new Guisos("Fideos caldosos con salmón",dePescado.getValue()));
////        guisosDao.insert(new Guisos("Merluza en salsa de langostinos",dePescado.getValue()));
////        guisosDao.insert(new Guisos("Marmitako de salmón",dePescado.getValue()));
////        guisosDao.insert(new Guisos("Merluza con patatas en salsa verde",dePescado.getValue()));
////        guisosDao.insert(new Guisos("Caldereta de lubina y dorada",dePescado.getValue()));
//        //De Verduras
//        guisosDao.insert(new Guisos("Crema de calabacín",tiposGuisosDao.getTipoId(TiposGuisos.GUISOS_DE_VERDURA).getValue()));
//        //guisosDao.insert(new Guisos("Crema de zanahoria ",deVerduras));
////        guisosDao.insert(new Guisos("Crema de remolacha y yogur",deVerduras.getValue()));
////        guisosDao.insert(new Guisos("Crema de coliflor con huevo",deVerduras.getValue()));
////        guisosDao.insert(new Guisos("Crema de setas",deVerduras.getValue()));
////        guisosDao.insert(new Guisos("Consomé de verduras",deVerduras.getValue()));
////        guisosDao.insert(new Guisos("Caldo de verduras",deVerduras.getValue()));
////        guisosDao.insert(new Guisos("Potaje tradicional de lentejas",deVerduras.getValue()));
////        guisosDao.insert(new Guisos("Guiso de espinacas con garbanzos",deVerduras.getValue()));
//
//        //---------------------------------------------------------

    }
}
