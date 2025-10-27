package com.mycompany.proyecto1;

import java.awt.datatransfer.*;
import javax.swing.*;

public class ComponenteTransferible implements Transferable {

    public static final DataFlavor COMPONENTE_FLAVOR = new DataFlavor(Componente.class, "Componente");
    private Componente componente;

    public ComponenteTransferible(Componente c) {
        this.componente = c;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{COMPONENTE_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return COMPONENTE_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) {
        return componente; // ya sabemos que siempre es el flavor correcto
    }
}
