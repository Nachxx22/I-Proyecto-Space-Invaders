package Client;

import Client.packets.AddPlayerPacket;
import Client.packets.RemovePlayerPacket;
import Objects.Player;

public class EventListener {

    public void received(Object p){
        if(p instanceof AddPlayerPacket){
            AddPlayerPacket packet = (AddPlayerPacket) p;
            PlayerHandler.players.put(packet.id,new NetPlayer(packet.id,packet.name));
            System.out.println(packet.name+"Has joined the game");
        }else if(p instanceof RemovePlayerPacket){
            RemovePlayerPacket socket= (RemovePlayerPacket)p;
            System.out.println(PlayerHandler.players.get(packet.id).name +"Has left the game");
            PlayerHandler.players.remove(packet.id);
        }
    }
}
