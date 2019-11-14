public void remove(Integer n){
	_numbers.remove(n);
}

public void addAt(int idx, Integer n){
	_numbers.add(inx,n);
}

_display

package ex.app.edit;

public class DoRemoveNumber extends Command<Integer> _number{
	private Input<Integer>_number;

	public DoRemoveNumber(IntegerManager m){
		super("Remover numero", m);
		_number = _form.addIntegerInput("Numero a remover: ");
	}

	protected void execute(){
		_form.parse();
		_receiver.remove(_number.value());
	}

}

public class DoAddNumberAt extends Command Input<IntegerManager> {
	private Input<Integer>_number;
	private Input<Integer> _position;

	public DoAddNumber(IntegerManager m){
		super("Remover numero", m);
		_number = _form.addIntegerInput("Numero a remover: ");
	}

	protected void execute(){
		_form.parse();
		_receiver.remove(_number.value());
	}

}

public class DoShowStarts(IntegerMAnager m){
	super("Apresentar Estatistica", m);
}
protected void execute(){
	long total = 0;
	List <Integer> numbers = _receiver.getAllNumbers();
	Iterator<Integer> iter = numbers.iteratos();
	while (iter.hashNext())
		totar+=iter.next();
}



// add(int idx, E obj)  - coloca o objeto naquela posicao la na lista pelo que endenti 