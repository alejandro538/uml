import React from 'react';
import { IonItem, IonLabel, IonInput } from '@ionic/react';

interface ClientFormProps {
  name: string;
  direccion: string;
  telefono: string;
  email: string;
  onChange: (field: 'name' | 'direccion' | 'telefono' | 'email', value: string) => void;
}

const ClientForm: React.FC<ClientFormProps> = ({ name, direccion, telefono, email, onChange }) => {
  return (
    <>
      <IonItem>
        <IonLabel position="stacked">Nombre</IonLabel>
        <IonInput
          value={name}
          placeholder="Ingresa tu nombre"
          onIonChange={(e) => onChange('name', e.detail.value!)}
        />
      </IonItem>
      <IonItem>
        <IonLabel position="stacked">Dirección</IonLabel>
        <IonInput
          value={direccion}
          placeholder="Ingresa tu dirección"
          onIonChange={(e) => onChange('direccion', e.detail.value!)}
        />
      </IonItem>
      <IonItem>
        <IonLabel position="stacked">Teléfono</IonLabel>
        <IonInput
          value={telefono}
          placeholder="Ingresa tu teléfono"
          onIonChange={(e) => onChange('telefono', e.detail.value!)}
        />
      </IonItem>
      <IonItem>
        <IonLabel position="stacked">Correo electrónico</IonLabel>
        <IonInput
          value={email}
          placeholder="Ingresa tu correo"
          onIonChange={(e) => onChange('email', e.detail.value!)}
        />
      </IonItem>
    </>
  );
};

export default ClientForm;
