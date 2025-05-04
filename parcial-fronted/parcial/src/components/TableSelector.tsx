import React from 'react';
import { IonItem, IonLabel, IonSelect, IonSelectOption } from '@ionic/react';
import { Mesa } from '../types/ReservaTypes';

interface TableSelectorProps {
  mesas: Mesa[];
  selectedMesaId: number;
  onChange: (mesaId: number) => void;
}

const TableSelector: React.FC<TableSelectorProps> = ({ mesas, selectedMesaId, onChange }) => {
  return (
    <IonItem>
      <IonLabel position="stacked">Selecciona una mesa</IonLabel>
      <IonSelect
        value={selectedMesaId}
        placeholder="Elige una mesa"
        onIonChange={(e) => onChange(Number(e.detail.value))}
      >
        {mesas.map((mesa) => (
          <IonSelectOption key={mesa.id} value={mesa.id}>
            Mesa #{mesa.number} - {mesa.seats} asientos
          </IonSelectOption>
        ))}
      </IonSelect>
    </IonItem>
  );
};

export default TableSelector;
