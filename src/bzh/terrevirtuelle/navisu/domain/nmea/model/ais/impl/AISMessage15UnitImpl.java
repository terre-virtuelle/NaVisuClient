package bzh.terrevirtuelle.navisu.domain.nmea.model.ais.impl;

import bzh.terrevirtuelle.navisu.domain.nmea.model.ais.impl.utils.Sixbit;
import bzh.terrevirtuelle.navisu.domain.nmea.model.ais.AISMessage15Message;
import bzh.terrevirtuelle.navisu.domain.nmea.model.ais.AISMessage15Unit;

/**
 * Field Nr Field Name NrOf Bits (from, to )
 * ------------------------------------------------------------------------ 1
 * destinationID 30	( 0, 29) 2	Message1 18	( 30, 47) "conditional spare" 3
 * Message2 18	( 50, 67)
 */
class AISMessage15UnitImpl implements AISMessage15Unit {

    private static final int DESTINATIONID_FROM = 0;
    private static final int DESTINATIONID_TO = 29;

    private int destinationID;

    /**
     * destinationID
     *
     * @return int value of destinationID1 (30 bits offset+[0,29])
     */
    public int getDestinationID() {
        return destinationID;
    }

    private AISMessage15MessageImpl[] messages;

    /**
     * messages
     *
     * @return AISMessage15Message[] value of messages
     */
    public AISMessage15MessageImpl[] getMessages() {
        return messages;
    }

    public AISMessage15UnitImpl() {
    }

    public AISMessage15UnitImpl(int offset, int nrofMessages, Sixbit content) {
        assert (content.length() >= offset + 17 + nrofMessages * 20);
        assert (nrofMessages == 1 || nrofMessages == 2);
        destinationID = content.getIntFromTo(offset + DESTINATIONID_FROM, offset + DESTINATIONID_TO);
        messages = new AISMessage15MessageImpl[nrofMessages];
        messages[0] = new AISMessage15MessageImpl(offset + 30, content);
        if (nrofMessages == 2) {
            messages[1] = new AISMessage15MessageImpl(offset + 50, content);
        }
        //TODO: should we remove a second message with all parameters set to zero?
    }
}
