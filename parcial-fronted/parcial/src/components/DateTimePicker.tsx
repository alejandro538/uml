import React from 'react';
import { IonItem, IonLabel, IonDatetime } from '@ionic/react';
import './DateTimePicker.css'; 

interface DateTimePickerProps {
  value: string;
  onChange: (value: string) => void;
}

const DateTimePicker: React.FC<DateTimePickerProps> = ({ value, onChange }) => {
  return (
    <IonItem className="datetime-picker-item">
      <IonLabel position="stacked" className="datetime-picker-label">
        Fecha y hora de la reserva
      </IonLabel>
      <IonDatetime
        display-format="YYYY-MM-DD HH:mm"
        value={value}
        onIonChange={(e) => {
          const newValue = e.detail.value;
          if (typeof newValue === 'string') {
            onChange(newValue);
          } else if (Array.isArray(newValue) && newValue.length > 0) {
            onChange(newValue[0]);
          }
        }}
      />
    </IonItem>
  );
};

export default DateTimePicker;
