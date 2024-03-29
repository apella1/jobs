# Concepts Covered Within The Services

## Iterables

### Jobs Service

- Other ways to iterate through the list.

  using for each
      for (Job job: jobs) {
        if (job.getId().equals(id)) {
            jobs.remove(job)
        }
      }

 using the Iterator interface

  Iterator<Job> iterator = jobs.iterator();
  while (iterator.hasNext()) {
    Job job = iterator.next();
    if (job.getId().equals(id)) {
        iterator.remove();
        return true;
    }
  }
  return false;