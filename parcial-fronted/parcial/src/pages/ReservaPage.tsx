import React, { useState } from 'react';
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonButton,
  IonToast,
} from '@ionic/react';

import DateTimePicker from '../components/DateTimePicker';
import ClientForm from '../components/ClientForm';
import TableSelector from '../components/TableSelector';
import { Mesa, Cliente } from '../types/ReservaTypes';

const mesasMock: Mesa[] = [
  { id: 1, number: 1, seats: 4 },
  { id: 2, number: 2, seats: 2 },
  { id: 3, number: 3, seats: 6 },
];

const ReservaPage: React.FC = () => {
  const [fechaHora, setFechaHora] = useState('');
  const [cliente, setCliente] = useState<Cliente>({
    name: '',
    direccion: '',
    telefono: '',
    email: '',
  });
  const [mesaId, setMesaId] = useState<number>(0);
  const [showToast, setShowToast] = useState(false);
  const [toastMessage, setToastMessage] = useState('');

  const handleSubmit = async () => {
    const reserva = {
      nombre: cliente.name,
      direccion: cliente.direccion,
      telefono: cliente.telefono,
      email: cliente.email,
      fechaHora: fechaHora,
      mesaId: mesaId,
    };

    try {
      const response = await fetch('http://localhost:8080/api/reservas', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(reserva),
      });

      if (response.ok) {
        setToastMessage('Reserva enviada correctamente');
        setFechaHora('');
        setCliente({ name: '', direccion: '', telefono: '', email: '' });
        setMesaId(0);
      } else {
        setToastMessage('Error al enviar la reserva');
      }
    } catch (error) {
      console.error('Error:', error);
      setToastMessage('Error de conexión con el servidor');
    }

    setShowToast(true);
  };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Gestión de Reservas</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonContent className="ion-padding">
        <DateTimePicker value={fechaHora} onChange={setFechaHora} />

        <ClientForm
          name={cliente.name}
          direccion={cliente.direccion}
          telefono={cliente.telefono}
          email={cliente.email}
          onChange={(field, value) => setCliente({ ...cliente, [field]: value })}
        />

        <TableSelector mesas={mesasMock} selectedMesaId={mesaId} onChange={setMesaId} />

        <IonButton expand="block" className="ion-margin-top" onClick={handleSubmit}>
          Confirmar Reserva
        </IonButton>

        <IonToast
          isOpen={showToast}
          message={toastMessage}
          duration={2000}
          onDidDismiss={() => setShowToast(false)}
        />
      </IonContent>
    </IonPage>
  );
};

export default ReservaPage;
