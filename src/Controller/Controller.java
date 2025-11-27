package Controller;

import Model.PrgState.PrgState;
import Model.Utils.Collections.MyHeap;
import Model.Value.RefValue;
import Model.Value.Value;
import Repository.IRepository;
import Model.Statement.IStmt;
import Model.Utils.Collections.MyIStack;
import Model.Utils.Exceptions.MyException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repository;
    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public PrgState oneStep(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getStk();
        if(stk.isEmpty()) throw new MyException("prgstate stack is empty");;
        IStmt crtStmt= stk.pop();
        return crtStmt.execute(state);
    }

    public void allStep() throws MyException
    {
        PrgState prg=repository.getCrtPrg();
        MyHeap.resetAddress();

        repository.logPrgStateExec();


        while(!prg.getStk().isEmpty())
        {

            oneStep(prg);

            repository.logPrgStateExec();
            prg.getHeapTable().setContent(safeGarbageCollector(
                    getAddrFromSymTable(prg.getSymTable().getContent().values()),
                    getAddrFromHeap(prg.getHeapTable().getContent().values()),
                    prg.getHeapTable().getContent()
            ));

            repository.logPrgStateExec();
        }
        prg.restoreOriginal();
    }

    Map<Integer, Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer,Value> heap)
    {
        return heap.entrySet().stream()
                .filter(e->symTableAddr.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    Map<Integer,Value> safeGarbageCollector(List<Integer> symTableAddr, List<Integer> heapTableAddr, Map<Integer,Value> heap)
    {

        return heap.entrySet().stream()
                .filter(e-> (symTableAddr.contains(e.getKey())) || heapTableAddr.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    List<Integer> getAddrFromSymTable(Collection<Value> symTableValues)
    {
        return symTableValues.stream()
                .filter(v->v instanceof RefValue)
                .map(v-> {RefValue v1=(RefValue)v; return v1.getAddress(); })
                .collect(Collectors.toList());
    }

    List<Integer> getAddrFromHeap(Collection<Value> heapTableValues)
    {
        return heapTableValues.stream()
                .filter(v->v instanceof RefValue)
                .map(v->{RefValue v1=(RefValue)v; return v1.getAddress(); })
                .collect(Collectors.toList());
    }
}